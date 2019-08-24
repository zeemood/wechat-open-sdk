package com.github.zeemood.wechat.pay.service.impl;

import com.github.zeemood.wechat.common.config.mobileapp.MobileAppProperties;
import com.github.zeemood.wechat.pay.enums.TradeTypeEnum;
import com.github.zeemood.wechat.pay.exception.WechatPayException;
import com.github.zeemood.wechat.pay.req.MobileAppPreBillRequest;
import com.github.zeemood.wechat.pay.req.MobileAppRefundApplyRequest;
import com.github.zeemood.wechat.pay.resp.MobileAppPreBillResponse;
import com.github.zeemood.wechat.pay.resp.MobileAppRefundApplyResponse;
import com.github.zeemood.wechat.pay.resp.RefundResponseDecode;
import com.github.zeemood.wechat.pay.resp.SettlementResponse;
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
 * 移动App支付业务类
 * </p>
 *
 * @author zeemoo
 * @since 2019/7/15 22:51
 */
@Setter
public class MobileAppBusinessService
        extends AbstractWechatBusinessService<
        MobileAppProperties
        , Map<String, Object>
        , MobileAppPreBillRequest
        , MobileAppPreBillResponse
        , SettlementResponse
        , MobileAppRefundApplyRequest
        , MobileAppRefundApplyResponse
        , RefundResponseDecode
        > {

    /**
     * 预付账单请求信息类
     *
     * @param outTradeNo
     * @param subject
     * @param totalAmount
     * @return
     */
    @Override
    public MobileAppPreBillRequest buildBillRequest(String outTradeNo, String subject, BigDecimal totalAmount) throws IllegalAccessException, InstantiationException {
        MobileAppPreBillRequest request = new MobileAppPreBillRequest();
        request.setOutTradeNo(outTradeNo);
        request.setSubject(String.format("%s-%s", super.getProperties().getAppName(), subject));
        request.setTotalAmount(totalAmount.multiply(ConstUtils.NUMERIC_HUNDRED).setScale(0, BigDecimal.ROUND_DOWN).abs());
        request.setTradeType(TradeTypeEnum.APP);
        request.setNonceStr(RandomStringUtils.randomAlphanumeric(32));
        return request;
    }

    /**
     * 在第三方支付平台上生成账单，* 此处记得先设置IP
     *
     * @param request
     * @return
     */
    @Override
    public MobileAppPreBillResponse genBill(MobileAppPreBillRequest request) {
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
            MobileAppPreBillResponse response = XmlUtils.toObject(new String(s.getBytes("iso8859-1"), "utf-8"), MobileAppPreBillResponse.class);
            super.checkResponseBusiness(response, subject);
            super.checkDataSignature(response, subject, response.getSign());
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            throw new WechatPayException("【统一下单】下单失败，网络请求失败：" + e.getMessage());
        }
    }

    /**
     * 转换成app调起微信支付所需要的信息
     *
     * @param response
     * @return
     */
    @Override
    public final Map<String, Object> transForView(MobileAppPreBillResponse response) {
        Map<String, Object> map = new HashMap<>(7);
        map.put("appid", response.getAppid());
        map.put("partnerid", response.getMchId());
        map.put("prepayid", response.getPrepayId());
        map.put("package", "Sign=WXPay");
        map.put("noncestr", RandomStringUtils.randomAlphanumeric(32));
        map.put("timestamp", System.currentTimeMillis() / 1000);
        map.put("sign", DataSignatureUtil.genSignature(map, getProperties().getPayKey()));
        return map;
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
    public MobileAppRefundApplyRequest buildRefundRequest(String transactionId, String outTradeNo, String outRefundNo, BigDecimal refundFee, BigDecimal totalFee) {
        MobileAppRefundApplyRequest request = new MobileAppRefundApplyRequest();
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
    public MobileAppRefundApplyResponse applyRefund(MobileAppRefundApplyRequest request) {
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
        MobileAppRefundApplyResponse response = XmlUtils.toObject(responseXml, MobileAppRefundApplyResponse.class);
        super.checkResponseBusiness(response, subject);
        // 验签
        super.checkDataSignature(response, subject, response.getSign());
        return response;
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
}
