package com.github.zeemood.wechat.login.service;

import com.github.zeemood.wechat.login.enums.UserInfoLangEnum;
import com.github.zeemood.wechat.login.resp.AccessTokenCheckResp;
import com.github.zeemood.wechat.login.resp.AccessTokenResp;
import com.github.zeemood.wechat.login.resp.WechatUserInfo;
import com.github.zeemood.wechat.login.resp.RefreshTokenResp;

/**
 * 微信登录业务模版
 *
 * @author zhang.shushan
 * @date 2019/4/28
 */
public interface IWechatLoginService {

    /**
     * 获取用户信息
     * @param accessToken
     * @param openid
     * @param lang
     * @return
     */
    WechatUserInfo achieveUserInfo(String accessToken, String openid, UserInfoLangEnum lang);

    /**
     * 检验接口调用凭证
     *
     * @param accessToken
     * @param openid
     * @return {@link AccessTokenCheckResp}errorCode为0时有效
     */
    AccessTokenCheckResp checkAccessToken(String accessToken, String openid);

    /**
     * 刷新接口调用凭证(access_token)
     *
     * @param refreshToken
     * @return
     */
    RefreshTokenResp refreshAccessToken(String refreshToken);

    /**
     * 使用code获取access_token
     *
     * @param code
     * @return
     */
    AccessTokenResp achieveAccessToken(String code);

}
