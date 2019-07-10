package com.github.zeemood.wechat.login.resp;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.zeemood.wechat.login.enums.SubscribeSceneEnum;
import com.github.zeemood.wechat.login.util.StringEncoder;
import com.vdurmont.emoji.EmojiParser;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.Date;

/**
 * @author zeemoo
 * @date 2019/7/10
 */
@Data
public class MpWechatUserInfo {
    /**
     * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息
     */
    private Integer subscribe;

    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    @JSONField(name = "subscribe_time")
    private Date subscribeTime;

    /**
     * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     */
    private String remark;

    /**
     * 用户所在的分组ID（兼容旧的用户分组接口）
     */
    @JSONField(name = "groupid")
    private Long groupId;

    /**
     * 用户被打上的标签ID列表
     */
    @JSONField(name = "tagid_list")
    private String[] tagidList;

    /**
     * 返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他
     */
    @JSONField(name = "subscribe_scene")
    private SubscribeSceneEnum subscribeScene;

    /**
     * 二维码扫码场景（开发者自定义）
     */
    @JSONField(name = "qr_scene")
    private String qrScene;

    /**
     * 二维码扫码场景描述（开发者自定义）
     */
    @JSONField(name = "qr_scene_str")
    private String qrSceneStr;

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
