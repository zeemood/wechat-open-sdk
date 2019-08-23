package com.github.zeemood.wechat.pay.service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * <p>
 * 退款抽象模版
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/23 23:56
 */
public interface IWechatRefundService<A, D, E> {
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
    A buildRefundRequest(String transactionId, String outTradeNo, String outRefundNo, BigDecimal refundFee, BigDecimal totalFee);

    /**
     * 退款申请
     *
     * @param request
     * @return
     */
    D applyRefund(A request);

    /**
     * 退款回调
     *
     * @param request
     * @return
     */
    E refundCallback(HttpServletRequest request, Class<E> eClass);
}
