package com.github.zeemood.wechat.login.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.zeemood.wechat.common.config.mp.MpProperties;
import com.github.zeemood.wechat.login.enums.ScopeEnum;
import com.github.zeemood.wechat.login.enums.UserInfoLangEnum;
import com.github.zeemood.wechat.login.exception.WechatLoginRespException;
import com.github.zeemood.wechat.login.resp.MpWechatUserInfo;
import com.github.zeemood.wechat.login.util.MpLoginUrlBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 公众号登录
 *
 * @author zeemoo
 * @date 2019/4/29
 */
public class MpLoginServiceImpl extends WechatLoginServiceImpl<MpProperties> {

    private static final String ACCESS_TOKEN_ACHIEVE_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    private static final String MP_SUBSCRIBE_USER_INFO_ACHIEVE_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=%s";

    /**
     * 构建登录地址
     *
     * @param state
     * @return
     */
    public String buildCodeUrl(String state, ScopeEnum scope) {
        MpProperties properties = getProperties();
        return MpLoginUrlBuilder.build4Code(properties.getAppid(), properties.getLoginCallbackUrl(), scope, state);
    }

    public MpWechatUserInfo achieveUserInfo(String openid, UserInfoLangEnum userInfoLangEnum) {
        //获取access_token
        String s = achieveAccessToken();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(String.format(MP_SUBSCRIBE_USER_INFO_ACHIEVE_URL, s, openid, userInfoLangEnum.getValue()), String.class);
        if (!forEntity.getStatusCode().equals(HttpStatus.OK)) {
            throw new WechatLoginRespException("授权信息获取错误");
        }
        String body = forEntity.getBody();
        MpWechatUserInfo wechatUserInfo = JSON.parseObject(body, MpWechatUserInfo.class);
        return wechatUserInfo;
    }

    public String achieveAccessToken() {
        MpProperties properties = getProperties();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(String.format(ACCESS_TOKEN_ACHIEVE_URL, properties.getAppid(), properties.getAppSecret()), Map.class);
        if (!forEntity.getStatusCode().equals(HttpStatus.OK)) {
            throw new WechatLoginRespException("获取AccessToken失败");
        }
        Map body = forEntity.getBody();
        Object accessToken = body.get("access_token");
        return accessToken.toString();
    }
}
