package com.github.zeemood.wechat.login.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 构建api时使用，设定回调接口能获取到的信息
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
@Getter
@AllArgsConstructor
public enum ScopeEnum {
    /**
     *
     */
    WEB_LOGIN("snsapi_login", "网页登录适用获取code")
    , BASE("snsapi_base", "对不同接口有不同作用，主要是刷新，校验，获取access_token")
    , USER_INFO("snsapi_userinfo", "获取用户信息");
    private String value;
    private String desc;
}
