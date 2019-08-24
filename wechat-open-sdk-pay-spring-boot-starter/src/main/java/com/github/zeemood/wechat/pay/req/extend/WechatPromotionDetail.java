package com.github.zeemood.wechat.pay.req.extend;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.zeemood.wechat.common.IValidateBean;
import com.github.zeemood.wechat.pay.enums.WechatPayResultEnum;
import com.github.zeemood.wechat.pay.exception.WechatPayException;
import com.github.zeemood.wechat.pay.utils.ConstUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * </p>
 *
 * @author zeemoo
 * @since 2019/7/15 23:59
 */
@Data
public class WechatPromotionDetail implements IValidateBean {
    @JSONField(name = "cost_price")
    private BigDecimal costPrice;
    @JSONField(name = "receipt_id")
    private String receiptId;
    @JSONField(name = "goods_detail")
    private List<Goods> goodsDetail;

    public Integer getCostPrice() {
        if (costPrice != null) {
            if (costPrice.compareTo(BigDecimal.ZERO) <= 0) {
                throw new WechatPayException(WechatPayResultEnum.ERR_COST_PRICE_ILLEGAL);
            }
            return costPrice.multiply(ConstUtils.NUMERIC_HUNDRED).intValue();
        }
        return null;
    }

    /**
     * 实体类参数自我检验
     */
    @Override
    public void validate() {
        if (costPrice != null && costPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new WechatPayException(WechatPayResultEnum.ERR_COST_PRICE_ILLEGAL);
        }
        if (StringUtils.isNotBlank(this.receiptId) && this.receiptId.length() > ConstUtils.STR_LENGTH_32) {
            throw new WechatPayException(WechatPayResultEnum.ERR_RECEIPTID_ILLEGAL);
        }
        if (goodsDetail == null || goodsDetail.isEmpty()) {
            throw new WechatPayException(WechatPayResultEnum.ERR_GOODS_DETAIL_EMPTY);
        } else {
            for (Goods goods : goodsDetail) {
                goods.validate();
            }
        }
    }
}
