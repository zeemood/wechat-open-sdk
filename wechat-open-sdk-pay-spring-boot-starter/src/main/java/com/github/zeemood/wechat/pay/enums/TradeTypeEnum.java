package com.github.zeemood.wechat.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 微信支付类型枚举类
 *
 * @author zeemoo
 * @since 2019/8/12 23:59
 */
@Getter
public enum TradeTypeEnum{
    /**
     * 交易类型
     */
    APP,JSAPI,NATIVE,MWEB;

}
