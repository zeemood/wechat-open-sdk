package com.github.zeemood.wechat.pay.resp;

import com.github.zeemood.wechat.pay.enums.RefundAccountEnum;
import com.github.zeemood.wechat.pay.enums.RefundSourceEnum;
import com.github.zeemood.wechat.pay.enums.RefundStatusEnum;
import com.github.zeemood.wechat.pay.utils.ConstUtils;
import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 解密后的退款信息
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/23 21:55
 */
@Data
@Root(name="root")
public class RefundResponseDecode {

    @Element(name = "transaction_id")
    private String transactionId;

    @Element(name = "out_trade_no")
    private String outTradeNo;

    @Element(name = "refund_id")
    private String refundId;

    @Element(name = "out_refund_no")
    private String outRefundNo;

    @Element(name="total_fee")
    private BigDecimal totalFee;

    @Element(name="settlement_total_fee",required = false)
    private BigDecimal settlementTotalFee;

    @Element(name = "refund_fee")
    private BigDecimal refundFee;

    @Element(name = "settlement_refund_fee")
    private BigDecimal settlementRefundFee;

    @Element(name = "refund_status")
    private RefundStatusEnum refundStatus;

    @Element(name = "success_time",required = false)
    private Date successTime;

    @Element(name = "refund_recv_accout")
    private String refundRecvAccout;

    @Element(name = "refund_account")
    private RefundAccountEnum refundAccount;

    @Element(name="refund_request_source")
    private RefundSourceEnum refundRequestSource;

    public BigDecimal getSettlementRefundFee(){
        return ConstUtils.bigDecimalConverter(this.settlementRefundFee);
    }

    public BigDecimal getRefundFee(){
        return ConstUtils.bigDecimalConverter(this.refundFee);
    }

    public BigDecimal getSettlementTotalFee(){
        return ConstUtils.bigDecimalConverter(this.settlementTotalFee);
    }

    public BigDecimal getTotalFee(){
        return ConstUtils.bigDecimalConverter(this.totalFee);
    }
}
