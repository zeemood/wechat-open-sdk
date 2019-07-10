package com.github.zeemood.wechat.login.resp;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.zeemood.wechat.login.util.StringEncoder;
import com.vdurmont.emoji.EmojiParser;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * 微信用户信息
 *
 * @author zhang.shushan
 * @date 2019/4/28
 */
@Data
public class WechatUserInfo extends BaseResp {

    /**
     * 普通用户的标识，对当前开发者帐号唯一
     */
    private String openid;
    /**
     * 普通用户昵称
     */
    private String nickname;
    /**
     * 普通用户性别，1为男性，2为女性
     */
    private Integer sex;
    /**
     * 普通用户个人资料填写的省份
     */
    private String province;
    /**
     * 普通用户个人资料填写的城市
     */
    private String city;
    /**
     * 国家，如中国为CN
     */
    private String country;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    @JSONField(name = "headimgurl")
    private String headImgUrl;
    /**
     * 用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
     */
    private String privilege;
    /**
     * 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的。
     */
    private String unionid;

    public String getNickname(){
        return getNickname("utf-8");
    }

    public String getCity(){
        return getCity("utf-8");
    }

    public String getProvince(){
        return getProvince("utf-8");
    }
    public String getCountry(){
        return getCountry("utf-8");
    }

    /**
     * 转换昵称
     *
     * @param charset
     * @return
     */
    public String getNickname(String charset) {
        return encode(this.nickname, charset, false);
    }

    /**
     * 转换昵称
     *
     * @param charset
     * @param parseEmoji
     * @return
     */
    public String getNickname(String charset, boolean parseEmoji) {
        return encode(this.nickname, charset, parseEmoji);
    }

    /**
     * 转换省份
     *
     * @param charset
     * @return
     */
    public String getCity(String charset) {
        return encode(this.city, charset, false);
    }

    /**
     * 转换省份字符串编码并转换emoji，适用于没有utf8mb4编码的数据库
     *
     * @param charset
     * @param parseEmoji
     * @return
     */
    public String getCity(String charset, boolean parseEmoji) {
        return encode(this.city, charset, parseEmoji);
    }

    /**
     * 转换省份
     *
     * @param charset
     * @return
     */
    public String getProvince(String charset) {
        return encode(this.province, charset, false);
    }

    /**
     * 转换省份字符串编码并转换emoji，适用于没有utf8mb4编码的数据库
     *
     * @param charset
     * @param parseEmoji
     * @return
     */
    public String getProvince(String charset, boolean parseEmoji) {
        return encode(this.province, charset, parseEmoji);
    }

    /**
     * 转换国家
     *
     * @param charset
     * @return
     */
    public String getCountry(String charset) {
        return encode(this.country, charset, false);
    }

    /**
     * 转换国家字符串编码
     *
     * @param charset
     * @param parseEmoji
     * @return
     */
    public String getCountry(String charset, boolean parseEmoji) {
        return encode(this.country, charset, parseEmoji);
    }

    protected String encode(String source, String charset, boolean parseEmoji) {
        Validate.notEmpty(charset, "转换编码不能为空");
        if (StringUtils.isEmpty(source)) {
            return source;
        }
        String encode = StringEncoder.encode(source, "ISO8859-1", charset);
        if (parseEmoji) {
            encode = EmojiParser.parseToAliases(encode);
        }
        return encode;
    }
}
