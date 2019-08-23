package com.github.zeemood.wechat.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 退款来源
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/23 23:11
 */
@Getter
@AllArgsConstructor
public enum RefundSourceEnum {

    /**
     * 来源
     */
    VENDOR_PLATFORM("商户平台");

    private String desc;
}
