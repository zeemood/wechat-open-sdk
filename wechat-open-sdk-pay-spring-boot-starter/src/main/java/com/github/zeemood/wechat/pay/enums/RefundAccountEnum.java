package com.github.zeemood.wechat.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 退款来源
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/23 23:07
 */
@Getter
@AllArgsConstructor
public enum RefundAccountEnum {

    /**
     * 退款来源
     */
    REFUND_SOURCE_RECHARGE_FUNDS("可用余额退款/基本账户")
    ,REFUND_SOURCE_UNSETTLED_FUNDS("未结算资金退款")
    ;
    private String desc;
}
