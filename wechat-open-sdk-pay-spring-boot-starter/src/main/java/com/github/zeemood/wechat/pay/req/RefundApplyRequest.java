package com.github.zeemood.wechat.pay.req;

import com.github.zeemood.wechat.pay.common.IValidateBean;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * <p>
 * 退款申请请求信息类
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/17 21:05
 */
@Data
@Root(name = "xml")
public class RefundApplyRequest implements IValidateBean {

    @Element
    private String appid;

    @Element(name = "mch_id")
    private String mchId;

    @Element(name = "nonce_str")
    private String nonceStr;

    @Element
    private String sign;

    @Element(name = "transaction_id", required = false)
    private String transactionId;

    @Element(name = "out_trade_no", required = false)
    private String outTradeNo;

    @Element(name = "out_refund_no")
    private String outRefundNo;

    @Element(name = "refund_fee")
    private BigDecimal refundFee;

    @Element(name = "total_fee")
    private BigDecimal totalFee;

    @Element(name = "refund_desc", required = false)
    private String refundDesc;

    @Element(name = "refund_account", required = false)
    private String refundAccount;

    @Element(name = "notify_url", required = false)
    private String notifyUrl;

    /**
     * 实体类参数自我检验
     */
    @Override
    public void validate() {
        Assert.hasText(this.appid, "【appid】缺失");
        Assert.hasText(this.mchId, "商户号【mchId】缺失");
        Assert.hasText(this.nonceStr, "随机字符串【nonceStr】缺失");
        Assert.hasText(this.sign, "数据签名【sign】缺失");
        if (StringUtils.isAllEmpty(this.transactionId, this.outTradeNo)) {
            throw new IllegalArgumentException("微信账单号【transactionId】和商户订单号【outTradeNo】两者不能同时为空");
        }
        Assert.hasText(this.outRefundNo, "商户退款单号【outRefundNo】缺失");
        Assert.notNull(this.totalFee, "订单总金额【totalFee】缺失");
        Assert.notNull(this.refundFee, "退款金额【refundFee】缺失");
    }
}
