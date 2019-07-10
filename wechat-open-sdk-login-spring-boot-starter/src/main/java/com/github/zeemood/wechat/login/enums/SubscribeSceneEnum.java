package com.github.zeemood.wechat.login.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 关注公众号途径
 * @author zeemoo
 * @date 2019/7/10
 */
@Getter
@AllArgsConstructor
public enum SubscribeSceneEnum {
    /**
     * 途径枚举
     */
    ADD_SCENE_SEARCH("公众号搜索")
    ,ADD_SCENE_PROFILE_CARD("名片分享")
    ,ADD_SCENE_QR_CODE("扫描二维码")
    ,ADD_SCENE_PROFILE_LINK("图文页内名称点击")
    ,ADD_SCENE_PROFILE_ITEM("图文页右上角菜单")
    ,ADD_SCENE_PAID("支付后关注")
    ,ADD_SCENE_OTHERS("其他")
    ,ADD_SCENE_ACCOUNT_MIGRATION("公众号迁移");
    private String desc;
}
