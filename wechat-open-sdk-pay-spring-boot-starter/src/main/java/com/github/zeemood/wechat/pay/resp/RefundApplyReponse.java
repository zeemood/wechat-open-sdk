package com.github.zeemood.wechat.pay.resp;

import com.github.zeemood.wechat.pay.utils.ConstUtils;
import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * <p>
 * 退款返回类
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/17 23:12
 */
@Data
@Root(name = "xml")
public class RefundApplyReponse extends BaseResponse {

    @Element(name = "appid", required = false)
    private String appid;

    @Element(name = "mch_id", required = false)
    private String mchId;

    @Element(name = "nonce_str", required = false)
    private String nonceStr;

    @Element(required = false)
    private String sign;

    @Element(name = "transaction_id", required = false)
    private String transactionId;

    @Element(name = "out_trade_no", required = false)
    private String outTradeNo;

    @Element(name = "out_refund_no", required = false)
    private String outRefundNo;

    @Element(name = "refund_id", required = false)
    private String refundId;

    @Element(name = "refund_fee", required = false)
    private BigDecimal refundFee;

    @Element(name = "settlement_refund_fee", required = false)
    private BigDecimal settlementRefundFee;

    @Element(name = "total_fee", required = false)
    private BigDecimal totalFee;

    @Element(name = "settlement_total_fee", required = false)
    private BigDecimal settlementTotalFee;

    @Element(name = "cash_fee", required = false)
    private BigDecimal cashFee;

    @Element(name = "cash_fee_type", required = false)
    private String cashFeeType;

    @Element(name = "cash_refund_fee", required = false)
    private BigDecimal cashRefundFee;

    @Element(name = "coupon_refund_fee", required = false)
    private BigDecimal couponRefundFee;

    @Element(name = "coupon_refund_count", required = false)
    private Integer couponRefundCount;

    public BigDecimal getRefundFee(){
        return ConstUtils.bigDecimalConverter(this.refundFee);
    }

    public BigDecimal getSettleRefundFee(){
        return ConstUtils.bigDecimalConverter(this.settlementRefundFee);
    }

    public BigDecimal getTotalFee(){
        return ConstUtils.bigDecimalConverter(this.totalFee);
    }

    public BigDecimal getSettlementTotalFee(){
        return ConstUtils.bigDecimalConverter(this.settlementTotalFee);
    }

    public BigDecimal getCashFee(){
        return ConstUtils.bigDecimalConverter(this.cashFee);
    }

    public BigDecimal getCashRefundFee(){
        return ConstUtils.bigDecimalConverter(this.cashRefundFee);
    }

    public BigDecimal getCouponRefundFee(){
        return ConstUtils.bigDecimalConverter(this.couponRefundFee);
    }
}
