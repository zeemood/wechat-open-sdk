package com.github.zeemood.wechat.login.util;

import com.github.zeemood.wechat.login.enums.ScopeEnum;
import org.apache.commons.lang3.Validate;

import java.net.URLEncoder;

/**
 * @author zhang.shushan
 * @date 2019/4/29
 */
public class MpLoginUrlBuilder {

    private final static String CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";

    /**
     * 构建登录地址
     *
     * @param appid
     * @param loginCallbackUrl
     * @param scope            高级功能scope可以获取到用户信息，类型选择为{@link ScopeEnum#USER_INFO}，否则选{@link ScopeEnum#BASE}
     * @param state
     * @return
     */
    public static String build4Code(String appid, String loginCallbackUrl, ScopeEnum scope, String state) {
        Validate.notBlank(appid, "应用ID不能为空");
        Validate.notBlank(loginCallbackUrl, "回调地址不能为空");
        Validate.notBlank(state, "为防止跨站攻击，state不能为空");
        Validate.notNull(scope, "scope必传。获取用户信息需要获取高级功能");
        return String.format(CODE_URL, appid, URLEncoder.encode(loginCallbackUrl), scope.getValue(), state);
    }
}
