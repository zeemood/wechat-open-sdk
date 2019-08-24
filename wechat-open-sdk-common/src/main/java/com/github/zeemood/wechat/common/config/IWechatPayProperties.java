package com.github.zeemood.wechat.common.config;

/**
 * 微信支付接口类
 * </p>
 *
 * @author zeemoo
 * @since 2019/7/13 15:29
 */
public interface IWechatPayProperties {

    /**
     * 获取应用名称
     *
     * @return
     */
    String getAppName();

    /**
     * 支付回调地址
     *
     * @return
     */
    String getPayCallbackUrl();

    /**
     * 支付密钥
     *
     * @return
     */
    String getPayKey();

    /**
     * 获取商户号
     *
     * @return
     */
    String getMchId();

    /**
     * 证书路径
     *
     * @return
     */
    String getCertificatePath();

    /**
     * 退款回调地址
     *
     * @return
     */
    String getRefundNotifyUrl();

    /**
     * 获取appid
     * @return
     */
    String getAppid();
}
