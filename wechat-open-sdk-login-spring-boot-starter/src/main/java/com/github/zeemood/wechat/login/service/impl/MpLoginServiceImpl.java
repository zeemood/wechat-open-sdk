package com.github.zeemood.wechat.login.service.impl;

import com.github.zeemood.wechat.common.config.mp.MpProperties;
import com.github.zeemood.wechat.login.enums.ScopeEnum;
import com.github.zeemood.wechat.login.util.MpLoginUrlBuilder;

/**
 * 公众号登录
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
public class MpLoginServiceImpl extends WechatLoginServiceImpl<MpProperties>{

    /**
     * 构建登录地址
     * @param state
     * @return
     */
    public String buildCodeUrl(String state, ScopeEnum scope) {
        MpProperties properties = getProperties();
        return MpLoginUrlBuilder.build4Code(properties.getAppid(), properties.getLoginCallbackUrl(),scope,state);
    }
}
