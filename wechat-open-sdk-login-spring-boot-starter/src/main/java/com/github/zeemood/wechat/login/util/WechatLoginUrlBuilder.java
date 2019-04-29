package com.github.zeemood.wechat.login.util;

import com.github.zeemood.wechat.login.enums.UserInfoLangEnum;
import org.apache.commons.lang3.Validate;

/**
 * 微信授权回调地址构建类
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
public class WechatLoginUrlBuilder {

    private final static String ACHIEVE_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    private final static String REFRESH_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";
    private final static String CHECK_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/auth?access_token=%s&openid=%s";
    private static final String USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s";

    /**
     * 构建获取AccessToken的地址
     *
     * @param appid
     * @param secret
     * @param code
     * @return
     */
    public static String buildAchieveAccessTokenUrl(String appid, String secret, String code) {
        Validate.notBlank(appid, "appid不能为空");
        Validate.notBlank(secret, "appScret不能为空");
        Validate.notBlank(code, "code不能为空");
        return String.format(ACHIEVE_ACCESS_TOKEN, appid, secret, code);
    }

    /**
     * 构建刷新接口调用凭证的地址
     *
     * @param appid
     * @param refreshToken
     * @return
     */
    public static String buildRefreshTokenUrl(String appid, String refreshToken) {
        Validate.notBlank(appid, "appid必传");
        Validate.notBlank(refreshToken, "refresh token必传");
        return String.format(REFRESH_ACCESS_TOKEN, appid, refreshToken);
    }

    /**
     * 构建检验access_token的地址
     * @param accessToken
     * @param openid
     * @return
     */
    public static String buildCheckAccessTokenUrl(String accessToken, String openid) {
        Validate.notBlank(accessToken, "access token必传");
        Validate.notBlank(openid, "openid必传");
        return String.format(CHECK_ACCESS_TOKEN, accessToken, openid);
    }

    /**
     * 构建获取用户信息的地址
     * @param accessToken
     * @param openid
     * @param lang
     * @return
     */
    public static String buildUserInfo(String accessToken, String openid, UserInfoLangEnum lang) {
        Validate.notBlank(accessToken, "accessToken必传");
        Validate.notBlank(openid, "openid必传");
        String format = String.format(USER_INFO, accessToken, openid,"%s");
        if(lang==null){
            int i = format.lastIndexOf("&");
            format = format.substring(0,i);
        }else{
            format = format.replace("%s",lang.getValue());
        }
        return format;
    }
}
