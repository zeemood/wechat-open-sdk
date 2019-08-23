package com.github.zeemood.wechat.pay.resp;

import com.github.zeemood.wechat.pay.enums.TradeTypeEnum;
import com.github.zeemood.wechat.pay.utils.ConstUtils;
import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * <p>
 * 支付完结后的回调
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/14 1:22
 */
@Data
@Root(name = "xml")
public class SettlementResponse extends BaseResponse {

    @Element(required = false)
    private String appid;

    @Element(name = "mch_id", required = false)
    private String mchId;

    @Element(required = false, name = "device_info")
    private String deviceInfo;

    @Element(required = false, name = "nonce_str")
    private String nonceStr;

    @Element(required = false)
    private String sign;

    @Element(required = false)
    private String openid;

    @Element(required = false, name = "is_subscribe")
    private String isSubscribe;

    @Element(required = false, name = "trade_type")
    private TradeTypeEnum tradeType;

    @Element(required = false, name = "bank_type")
    private String bankType;

    @Element(required = false, name = "total_fee")
    private BigDecimal totalFee;

    @Element(required = false, name = "fee_type")
    private String feeType;

    @Element(required = false, name = "cashFee")
    private BigDecimal cashFee;

    @Element(required = false, name = "cash_fee_type")
    private String cashFeeType;

    @Element(required = false, name = "coupon_fee")
    private BigDecimal couponFee;

    @Element(required = false, name = "coupon_count")
    private Integer couponCount;

    @Element(required = false, name = "transaction_id")
    private Integer transactionId;

    @Element(required = false, name = "out_trade_no")
    private String outTradeNo;

    @Element(required = false)
    private String attach;

    @Element(required = false, name = "time_end")
    private String timeEnd;

    public BigDecimal getCouponFee() {
        return ConstUtils.bigDecimalConverter(this.couponFee);
    }

    public BigDecimal getCashFee() {
        return ConstUtils.bigDecimalConverter(this.cashFee);
    }

    public BigDecimal getTotalFee() {
        return ConstUtils.bigDecimalConverter(this.totalFee);
    }
}
