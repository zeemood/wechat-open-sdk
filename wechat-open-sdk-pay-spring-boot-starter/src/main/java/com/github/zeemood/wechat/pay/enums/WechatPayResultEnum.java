package com.github.zeemood.wechat.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 微信支付结果处理枚举类
 * </p>
 *
 * @author zeemoo
 * @since 2019/7/16 0:09
 */
@AllArgsConstructor
@Getter
public enum WechatPayResultEnum {

    /**
     * 结果枚举
     */
    ERR_GOODS_DETAIL_EMPTY(1000, "单品优惠活动订单详情不能为空")
    , ERR_GOODS_ID_ILLEGAL(1001, "单品货物ID必传，长度为32")
    , ERR_WX_GOODS_ID_ILLEGAL(1002,"微信支付定义的统一商品编号长度小于32")
    , ERR_GOODS_NAME_ILLEGAL(1003,"单品名称长度不能超过256")
    , ERR_QUANTITY_ILLEGAL(1004,"商品数量不合法" )
    , ERR_COST_PRICE_ILLEGAL(1005,"订单原价必须大于0" )
    , ERR_RECEIPTID_ILLEGAL(1006,"商家小票id长度不超过32" );
    private Integer code;
    private String desc;
}
