package com.github.zeemood.wechat.login.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhang.shushan
 * @date 2019/4/28
 */
@Getter
@AllArgsConstructor
public enum UserInfoLangEnum {
    /**
     * 语言枚举类
     */
    DEFAULT("zh_CN", "简体中文"), EN("en", "英语"), ZH_TW("zh_TW", "繁体中文"), ZH_CN("zh_CN", "简体中文");
    private String value;
    private String desc;
}
