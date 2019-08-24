package com.github.zeemood.wechat.pay.req;

import com.github.zeemood.wechat.common.IValidateBean;
import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * <p>
 * 预付账单请求信息基础类,包含三要素，自己生成的账单编号（即微信<br/>
 * 支付的商家订单号，笔者觉得账单的概念比较容易理解），结算价格，<br/>
 * 订单描述
 * </p>
 *
 * @author zeemoo
 * @since 2019/7/15 22:57
 */
@Data
@Root(name = "xml")
public abstract class PreBillRequest implements IValidateBean {

    /**
     * 账单编号
     */
    @Element(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 结算价格
     */
    @Element(name = "total_fee")
    private BigDecimal totalAmount;

    /**
     * 账单的描述或概要
     */
    @Element(name = "body")
    private String subject;
}
