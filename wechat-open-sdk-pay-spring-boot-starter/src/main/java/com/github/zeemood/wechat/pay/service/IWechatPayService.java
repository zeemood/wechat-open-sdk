package com.github.zeemood.wechat.pay.service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * <p>
 * 微信支付抽象模版
 * </p>
 *
 * @author zeemoo
 * @since 2019/7/15 22:50
 */
public interface IWechatPayService<B, R, F> {

    /**
     * 预付账单请求信息类，使用这个方法构建，
     * 可以在支付过程中补充其他的非必填参数。
     * 如，使用多态的方式，集成请求信息类，补
     * 充自己所需要的字段，然后进行第三方支付
     * 的账单生成
     *
     * @param billSn          商户系统的订单号
     * @param billDesc        订单描述
     * @param settlementPrice 结算价格
     * @return
     */
    B buildBillRequest(String billSn, String billDesc, BigDecimal settlementPrice) throws IllegalAccessException, InstantiationException;

    /**
     * 在第三方支付平台上生成账单
     *
     * @param request
     * @return
     */
    R genBill(B request);

    /**
     * 支付回调
     *
     * @param request
     * @param fClass
     * @return
     */
    F payCallback(HttpServletRequest request, Class<F> fClass);

}
