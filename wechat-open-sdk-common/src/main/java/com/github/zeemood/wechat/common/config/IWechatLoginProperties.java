package com.github.zeemood.wechat.common.config;

/**
 * @author zhang.shushan
 * @date 2019/4/29
 */
public interface IWechatLoginProperties {

    /**
     * 登录回调接口
     * @return
     */
    String getLoginCallbackUrl();

    /**
     * 应用id
     *
     * @return
     */
    String getAppid();

    /**
     * 应用密钥
     *
     * @return
     */
    String getAppSecret();
}
