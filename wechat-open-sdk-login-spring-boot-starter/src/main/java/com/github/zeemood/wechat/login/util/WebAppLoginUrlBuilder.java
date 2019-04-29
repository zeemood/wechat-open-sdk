package com.github.zeemood.wechat.login.util;

import org.apache.commons.lang3.Validate;

import java.net.URLEncoder;

/**
 * 微信登录网站登录链接构建类
 *
 * @author zhang.shushan
 * @date 2019/4/28
 */
public class WebAppLoginUrlBuilder {

    /**
     * 获取code的地址模版
     */
    private final static String CODE_URL = "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";

    /**
     * 构建获取code的地址
     *
     * @param appid
     * @param loginCallBackUrl
     * @param state
     * @return
     */
    public static String build4Code(String appid, String loginCallBackUrl, String state) {
        //检验参数
        Validate.notBlank(appid, "应用ID不能为空");
        Validate.notBlank(loginCallBackUrl, "回调地址不能为空");
        Validate.notBlank(state, "为防止跨站攻击，state不能为空");
        return String.format(CODE_URL, appid, URLEncoder.encode(loginCallBackUrl), state);
    }
}
