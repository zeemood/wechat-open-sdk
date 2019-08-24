package com.github.zeemood.wechat.login.service.impl;

import com.github.zeemood.wechat.login.enums.UserInfoLangEnum;
import com.github.zeemood.wechat.login.resp.AccessTokenCheckResp;
import com.github.zeemood.wechat.login.util.ResponseConverter;
import com.github.zeemood.wechat.common.config.IWechatLoginProperties;
import com.github.zeemood.wechat.login.resp.AccessTokenResp;
import com.github.zeemood.wechat.login.resp.RefreshTokenResp;
import com.github.zeemood.wechat.login.resp.WechatUserInfo;
import com.github.zeemood.wechat.login.service.IWechatLoginService;
import com.github.zeemood.wechat.login.util.WechatLoginUrlBuilder;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 微信登录功能接口
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
@Data
public class WechatLoginServiceImpl<T extends IWechatLoginProperties> implements IWechatLoginService {

    private T properties;

    private static RestTemplate restTemplate = new RestTemplate();

    @Override
    public WechatUserInfo achieveUserInfo(String accessToken, String openid, UserInfoLangEnum lang) {
        String s = WechatLoginUrlBuilder.buildUserInfo(accessToken, openid, lang);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(s, String.class);
        return ResponseConverter.convertAndCheck(forEntity, WechatUserInfo.class);
    }

    /**
     * 检验接口调用凭证
     *
     * @param accessToken
     * @param openid
     * @return {@link AccessTokenCheckResp}errorCode为0时有效
     */
    @Override
    public AccessTokenCheckResp checkAccessToken(String accessToken, String openid) {
        String s = WechatLoginUrlBuilder.buildCheckAccessTokenUrl(accessToken, openid);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(s, String.class);
        return ResponseConverter.convertAndCheck(forEntity, AccessTokenCheckResp.class);

    }

    /**
     * 刷新接口调用凭证(access_token)
     *
     * @param refreshToken
     * @return
     */
    @Override
    public RefreshTokenResp refreshAccessToken(String refreshToken) {
        String s = WechatLoginUrlBuilder.buildRefreshTokenUrl(properties.getAppid(), refreshToken);
        ResponseEntity<String> entity = restTemplate.getForEntity(s, String.class);
        return ResponseConverter.convertAndCheck(entity, RefreshTokenResp.class);
    }

    /**
     * 使用code获取access_token
     *
     * @param code
     * @return
     */
    @Override
    public AccessTokenResp achieveAccessToken(String code) {
        String s = WechatLoginUrlBuilder.buildAchieveAccessTokenUrl(properties.getAppid(), properties.getAppSecret(), code);
        ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity(s, String.class);
        AccessTokenResp accessTokenResp = ResponseConverter.convertAndCheck(stringResponseEntity, AccessTokenResp.class);
        return accessTokenResp;
    }

}
