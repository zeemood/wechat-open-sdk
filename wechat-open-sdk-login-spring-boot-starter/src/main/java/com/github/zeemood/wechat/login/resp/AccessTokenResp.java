package com.github.zeemood.wechat.login.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 获取access_token时，微信返回的信息
 *
 * @author zhang.shushan
 * @date 2019/4/28
 */
@Data
public class AccessTokenResp extends BaseResp{

    /**
     * 接口调用凭证
     */
    @JSONField(name = "access_token")
    private String accessToken;
    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    @JSONField(name = "expires_in")
    private Integer expiresIn;
    /**
     * 授权用户唯一标识
     */
    private String openid;
    /**
     * 当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。
     * 注：公众号没有绑定开放平台将获取不到这个参数
     */
    private String unionid;
    /**
     * 用户授权的作用域，使用逗号（,）分隔。网站应用目前只有一个snsapi_login
     */
    private String scope;
    /**
     * 用户刷新access_token
     */
    @JSONField(name = "refresh_token")
    private String refreshToken;
}
