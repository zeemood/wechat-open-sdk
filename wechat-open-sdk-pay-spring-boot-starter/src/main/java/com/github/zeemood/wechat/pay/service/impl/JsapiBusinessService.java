package com.github.zeemood.wechat.pay.service.impl;

import com.github.zeemood.wechat.pay.common.config.mp.MpProperties;
import com.github.zeemood.wechat.pay.enums.TradeTypeEnum;
import com.github.zeemood.wechat.pay.exception.WechatPayException;
import com.github.zeemood.wechat.pay.req.JsapiPreBillRequest;
import com.github.zeemood.wechat.pay.req.JsapiRefundApplyRequest;
import com.github.zeemood.wechat.pay.resp.*;
import com.github.zeemood.wechat.pay.utils.ConstUtils;
import com.github.zeemood.wechat.pay.utils.DataSignatureUtil;
import com.github.zeemood.wechat.pay.utils.HttpClientUtils;
import com.github.zeemood.wechat.pay.utils.XmlUtils;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 微信公众号支付
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 13:55
 */
@Setter
public class JsapiBusinessService extends AbstractWechatBusinessService<
        MpProperties
        , Map<String, Object>
        , JsapiPreBillRequest
        , JsapiPreBillResponse
        , SettlementResponse
        , JsapiRefundApplyRequest
        , JsapiRefundApplyResponse
        , RefundResponseDecode
        > {
    /**
     * 给前端转换成调用支付所需要的信息
     *
     * @param response
     * @return
     */
    @Override
    public Map<String, Object> transForView(JsapiPreBillResponse response) {
        Map<String, Object> map = new HashMap<>(6);
        map.put("appId", response.getAppid());
        map.put("timeStamp", System.currentTimeMillis() / 1000);
        map.put("nonceStr", RandomStringUtils.randomAlphanumeric(32));
        map.put("package", response.getPrepayId());
        map.put("signType", "MD5");
        map.put("paySign", DataSignatureUtil.genSignature(map, super.getProperties().getPayKey()));
        return map;
    }

    /**
     * 支付回调
     *
     * @param request
     * @return
     */
    @Override
    public SettlementResponse payCallback(HttpServletRequest request) {
        return super.payCallback(request, SettlementResponse.class);
    }

    /**
     * 退款回调
     *
     * @param request
     * @return
     */
    @Override
    public RefundResponseDecode refundCallBack(HttpServletRequest request) {
        return super.refundCallback(request, RefundResponseDecode.class);
    }

    /**
     * 预付账单请求信息类，使用这个方法构建，
     * 可以在支付过程中补充其他的非必填参数。
     * 如，使用多态的方式，集成请求信息类，补
     * 充自己所需要的字段，然后进行第三方支付
     * 的账单生成
     *
     * @param outTradeNo  商户系统的订单号
     * @param subject     订单描述
     * @param totalAmount 结算价格
     * @return
     */
    @Override
    public JsapiPreBillRequest buildBillRequest(String outTradeNo, String subject, BigDecimal totalAmount) throws IllegalAccessException, InstantiationException {
        JsapiPreBillRequest request = new JsapiPreBillRequest();
        request.setOutTradeNo(outTradeNo);
        request.setSubject(String.format("%s-%s", super.getProperties().getAppName(), subject));
        request.setTotalAmount(totalAmount.multiply(ConstUtils.NUMERIC_HUNDRED).setScale(0, BigDecimal.ROUND_DOWN).abs());
        request.setTradeType(TradeTypeEnum.APP);
        request.setNonceStr(RandomStringUtils.randomAlphanumeric(32));
        return null;
    }

    /**
     * 在第三方支付平台上生成账单
     *
     * @param request
     * @return
     */
    @Override
    public JsapiPreBillResponse genBill(JsapiPreBillRequest request) {
        String subject = "统一下单";

        request.setAppid(super.getProperties().getAppid());
        request.setNotifyUrl(super.getProperties().getPayCallbackUrl());
        request.setMchId(super.getProperties().getAppid());
        // 签名
        String sign = DataSignatureUtil.genSignature(request, super.getProperties().getPayKey());
        request.setSign(sign);
        // 校验参数
        request.validate();
        //进行请求
        try {
            String s = HttpClientUtils.postXml(XmlUtils.toXml(request), ConstUtils.UNIFIED_ORDER_URL);
            if (StringUtils.isEmpty(s)) {
                throw new IOException();
            }
            JsapiPreBillResponse response = XmlUtils.toObject(new String(s.getBytes("iso8859-1"), "utf-8"), JsapiPreBillResponse.class);
            super.checkResponseBusiness(response, subject);
            super.checkDataSignature(response, subject, response.getSign());
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            throw new WechatPayException("【统一下单】下单失败，网络请求失败：" + e.getMessage());
        }
    }

    /**
     * 退款信息类填写
     *
     * @param transactionId
     * @param outTradeNo
     * @param outRefundNo
     * @param refundFee
     * @param totalFee
     * @return
     */
    @Override
    public JsapiRefundApplyRequest buildRefundRequest(String transactionId, String outTradeNo, String outRefundNo, BigDecimal refundFee, BigDecimal totalFee) {
        JsapiRefundApplyRequest request = new JsapiRefundApplyRequest();
        request.setTransactionId(transactionId);
        request.setOutTradeNo(outTradeNo);
        request.setOutRefundNo(outRefundNo);
        request.setRefundFee(refundFee.multiply(ConstUtils.NUMERIC_HUNDRED).setScale(0).abs());
        request.setTotalFee(totalFee.multiply(ConstUtils.NUMERIC_HUNDRED).setScale(0).abs());
        return request;
    }

    /**
     * 退款申请
     *
     * @param request
     * @return
     */
    @Override
    public JsapiRefundApplyResponse applyRefund(JsapiRefundApplyRequest request) {
        String subject = "申请退款";

        request.setAppid(super.getProperties().getAppid());
        request.setMchId(super.getProperties().getMchId());
        request.setNonceStr(RandomStringUtils.randomAlphanumeric(32));
        request.setNotifyUrl(super.getProperties().getRefundNotifyUrl());
        request.setSign(DataSignatureUtil.genSignature(request, super.getProperties().getPayKey()));
        request.validate();
        String xml = XmlUtils.toXml(request);
        String responseXml = HttpClientUtils.postXmlWithCertificate(ConstUtils.REFUND_APPLY_URL, xml, super.getProperties().getCertificatePath(), super.getProperties().getMchId());
        if (StringUtils.isEmpty(responseXml)) {
            throw new WechatPayException("【申请退款】退款请求失败");
        }
        JsapiRefundApplyResponse response = XmlUtils.toObject(responseXml, JsapiRefundApplyResponse.class);
        super.checkResponseBusiness(response, subject);
        // 验签
        super.checkDataSignature(response, subject, response.getSign());
        return response;
    }
}
