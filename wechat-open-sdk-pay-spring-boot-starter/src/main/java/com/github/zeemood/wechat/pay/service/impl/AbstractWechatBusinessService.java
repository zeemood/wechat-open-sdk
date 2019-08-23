package com.github.zeemood.wechat.pay.service.impl;

import com.github.zeemood.wechat.pay.common.config.IWechatPayProperties;
import com.github.zeemood.wechat.pay.enums.ResultEnum;
import com.github.zeemood.wechat.pay.exception.WechatPayException;
import com.github.zeemood.wechat.pay.req.PreBillRequest;
import com.github.zeemood.wechat.pay.req.RefundApplyRequest;
import com.github.zeemood.wechat.pay.resp.*;
import com.github.zeemood.wechat.pay.service.IWechatPayService;
import com.github.zeemood.wechat.pay.service.IWechatRefundService;
import com.github.zeemood.wechat.pay.utils.AESUtil;
import com.github.zeemood.wechat.pay.utils.DataSignatureUtil;
import com.github.zeemood.wechat.pay.utils.XmlUtils;
import lombok.Getter;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.Base64Utils;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.TreeMap;

/**
 * <p>
 * 微信业务实现抽象类
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/23 23:58
 */
@Getter
public abstract class AbstractWechatBusinessService<
        C extends IWechatPayProperties
        , V
        , B extends PreBillRequest
        , R extends PreBillResponse
        , F extends SettlementResponse
        , A extends RefundApplyRequest
        , D extends RefundApplyReponse
        , E extends RefundResponseDecode
        > implements IWechatPayService<B, R, F>, IWechatRefundService<A, D, E> {

    private C properties;

    /**
     * 给前端转换成调用支付所需要的信息
     *
     * @param response
     * @return
     */
    public abstract V transForView(R response);

    /**
     * 支付回调
     *
     * @param request
     * @return
     */
    public abstract F payCallback(HttpServletRequest request);

    /**
     * 支付回调
     *
     * @param request
     * @return
     */
    @Override
    public F payCallback(HttpServletRequest request, Class<F> fClass) {
        String subject = "支付结果通知";
        try {
            ServletInputStream inputStream = request.getInputStream();
            byte[] bytes = StreamUtils.copyToByteArray(inputStream);
            String xmlStr = new String(bytes);
            F response = XmlUtils.toObject(xmlStr, fClass);
            this.checkResponseBusiness(response, subject);
            // 将xml转换成map之后再进行验签，避免使用优惠券之后,导致验签失败
            this.checkDataSignature(XmlUtils.toObject(xmlStr, TreeMap.class), subject, response.getSign());
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            throw new WechatPayException("【支付结果通知】解析回调信息失败");
        }
    }

    /**
     * 退款回调
     *
     * @param request
     * @return
     */
    public abstract E refundCallBack(HttpServletRequest request);

    /**
     * 退款回调
     *
     * @param request
     * @param eClass
     * @return
     */
    @Override
    public E refundCallback(HttpServletRequest request, Class<E> eClass) {
        try {
            ServletInputStream inputStream = request.getInputStream();
            byte[] bytes = StreamUtils.copyToByteArray(inputStream);
            String xmlStr = new String(bytes);
            RefundResponse response = XmlUtils.toObject(xmlStr, RefundResponse.class);
            this.checkResponseBusiness(response, "退款回调通知");
            String reqInfo = response.getReqInfo();
            //base64解码
            byte[] encodeBytes = Base64Utils.decodeFromString(reqInfo);
            //商户key做md5，全小写的key*
            String payKey = this.properties.getPayKey();
            String s = DigestUtils.md5Hex(payKey).toLowerCase();
            //用key*对加密串B做AES-256-ECB解密（PKCS7Padding）
            String responseXmlStr = AESUtil.Aes256Decode(encodeBytes, s.getBytes());
            E e = XmlUtils.toObject(responseXmlStr, eClass);
            return e;
        } catch (IOException e) {
            e.printStackTrace();
            throw new WechatPayException("【退款回调通知】解析回调信息失败");
        }
    }

    /**
     * 数据签名校验
     *
     * @param object
     * @param subject
     * @param sign
     */
    public void checkDataSignature(Object object, String subject, String sign) {
        boolean b = DataSignatureUtil.checkSign(object, this.properties.getPayKey(), sign);
        if (!b) {
            throw new WechatPayException(
                    "【支付结果通知】验签失败，签名不一致。如有使用优惠券业务导致验签失败，请自行验签。"
            );
        }
    }

    /**
     * 返回数据业务校验
     *
     * @param response
     * @param subject
     */
    public void checkResponseBusiness(BaseResponse response, String subject) {
        ResultEnum returnCode = response.getReturnCode();
        if (returnCode.equals(ResultEnum.FAIL)) {
            throw new WechatPayException(
                    "【%s】%s失败,【returnCode】为%s,%s"
                    , subject
                    , subject
                    , response.getReturnCode()
                    , response.getReturnMsg()
            );
        }
        ResultEnum resultCode = response.getResultCode();
        if (resultCode.equals(ResultEnum.FAIL)) {
            throw new WechatPayException(
                    "【%s】业务失败，【errCode】为%s:%s"
                    , subject
                    , response.getErrCode()
                    , response.getErrCodeDes()
            );
        }
    }

}
