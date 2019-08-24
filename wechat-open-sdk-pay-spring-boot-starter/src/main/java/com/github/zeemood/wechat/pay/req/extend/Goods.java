package com.github.zeemood.wechat.pay.req.extend;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.zeemood.wechat.common.IValidateBean;
import com.github.zeemood.wechat.pay.enums.WechatPayResultEnum;
import com.github.zeemood.wechat.pay.exception.WechatPayException;
import com.github.zeemood.wechat.pay.utils.ConstUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * 单品货物详情，这个感觉有点绕，笔者用的很少
 * </p>
 *
 * @author zeemoo
 * @since 2019/7/16 0:03
 */
@Data
public class Goods implements IValidateBean {
    /**
     * 由半角的大小写字母、数字、中划线、下划线中的一种或几种组成
     */
    @JSONField(name = "goods_id")
    private String goodsId;
    /**
     * 微信支付定义的统一商品编号（没有可不传）
     */
    @JSONField(name = "wxpay_goods_id")
    private String wxpayGoodsId;
    /**
     * 商品的实际名称
     */
    @JSONField(name = "goods_name")
    private String goodsName;
    /**
     * 用户购买的数量
     */
    private Integer quantity;

    /**
     * 单位为：分。如果商户有优惠，需传输商户优惠后的单价(例如：用户对一笔100元的订单使用了商场发的纸质优惠券100-50，则活动商品的单价应为原单价-50)
     */
    private BigDecimal price;

    public Integer getPrice() {
        if (this.price == null || this.price.compareTo(BigDecimal.ONE) < 0) {
            throw new WechatPayException(WechatPayResultEnum.ERR_QUANTITY_ILLEGAL);
        }
        return this.price.multiply(ConstUtils.NUMERIC_HUNDRED).intValue();
    }

    /**
     * 实体类参数自我检验
     */
    @Override
    public void validate() {
        if (StringUtils.isBlank(this.goodsId) || this.goodsId.length() > ConstUtils.STR_LENGTH_32) {
            throw new WechatPayException(WechatPayResultEnum.ERR_GOODS_ID_ILLEGAL);
        }
        if (StringUtils.isNotBlank(this.wxpayGoodsId) && this.wxpayGoodsId.length() > ConstUtils.STR_LENGTH_32) {
            throw new WechatPayException(WechatPayResultEnum.ERR_WX_GOODS_ID_ILLEGAL);
        }
        if (StringUtils.isNotBlank(this.goodsName) && this.goodsName.length() > ConstUtils.STR_LENGTH_256) {
            throw new WechatPayException(WechatPayResultEnum.ERR_GOODS_NAME_ILLEGAL);
        }
        if (this.quantity == null || this.quantity <= 0) {
            throw new WechatPayException(WechatPayResultEnum.ERR_QUANTITY_ILLEGAL);
        }
        if (this.price == null || this.price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new WechatPayException(WechatPayResultEnum.ERR_QUANTITY_ILLEGAL);
        }
    }

}
