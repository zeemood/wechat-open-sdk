package com.github.zeemood.wechat.login.service.impl;

import com.github.zeemood.wechat.common.config.webapp.WebAppProperties;
import com.github.zeemood.wechat.login.util.WebAppLoginUrlBuilder;

/**
 * 网页登录
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
public class WebAppLoginServiceImpl extends WechatLoginServiceImpl<WebAppProperties> {

    /**
     * 构建登录地址
     * @param state
     * @return
     */
    public String buildCodeUrl(String state) {
        WebAppProperties properties = getProperties();
        return WebAppLoginUrlBuilder.build4Code(properties.getAppid(), properties.getLoginCallbackUrl(), state);
    }
}
