package com.github.zeemood.wechat.common.config.mobileapp;

import com.github.zeemood.wechat.common.config.IWechatLoginProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 移动app的配置
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
@Data
@ConfigurationProperties("zeemoo.wechat.mobile")
public class MobileAppProperties implements IWechatLoginProperties {
    /**
     * 应用id
     */
    private String appid;
    /**
     * 密钥
     */
    private String appSecret;
    /**
     * 登录回调地址,移动应用可以忽略，没有授权域的限制
     */
    @Deprecated
    private String loginCallbackUrl;
}
