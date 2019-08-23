package com.github.zeemood.wechat.pay.enums;

import lombok.Getter;

/**
 * <p>
 * 退款状态
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/23 22:51
 */
@Getter
public enum RefundStatusEnum {

    /**
     * 退款状态,成功，异常，退款关闭
     */
    SUCCESS,CHANGE,REFUNDCLOSE;
}
