package com.github.zeemood.wechat.common.config.webapp;

import com.github.zeemood.wechat.common.config.IWechatLoginProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 网站应用配置类
 *
 * @author zhang.shushan
 * @date 2019/4/28
 */
@Data
@ConfigurationProperties(prefix = "zeemoo.wechat.webapp")
public class WebAppProperties implements IWechatLoginProperties {
    /**
     * 应用id
     */
    private String appid;
    /**
     * 密钥
     */
    private String appSecret;
    /**
     * 登录回调地址
     */
    private String loginCallbackUrl;
    /**
     * 商户号
     */
    private String mchId;
    /**
     * 支付密钥
     */
    private String payKey;
    /**
     * 支付回调地址
     */
    private String payCallbackUrl;
}
