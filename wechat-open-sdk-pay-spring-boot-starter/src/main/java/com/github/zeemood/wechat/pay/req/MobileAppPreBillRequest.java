package com.github.zeemood.wechat.pay.req;

import com.github.zeemood.wechat.pay.enums.TradeTypeEnum;
import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.springframework.util.Assert;

/**
 * <p>
 * 微信APP支付生成账单信息的请求类
 * </p>
 *
 * @author zeemoo
 * @since 2019/7/15 23:25
 */
@Data
@Root(name = "xml", strict = true)
public class MobileAppPreBillRequest extends PreBillRequest {

    /**
     * 微信开放平台审核通过的应用APPID（请登录open.weixin.qq.com查看，注意与公众号的APPID不同）
     */
    @Element(required = true)
    private String appid;

    /**
     * 商户号
     */
    @Element(name = "mch_id", required = true)
    private String mchId;

    /**
     * 终端设备号(门店号或收银设备ID)，默认请传"WEB"
     */
    @Element(name = "device_info", required = false)
    private String deviceInfo = "WEB";

    /**
     * 随机字符串，不长于32位。
     */
    @Element(name="nonce_str")
    private String nonceStr;

    /**
     * 数据签名
     */
    @Element
    private String sign;

    /**
     * 交易终端的ip
     */
    @Element(name="spbill_create_ip")
    private String spbillCreateIp;

    /**
     * 交易类型
     */
    @Element(name="trade_type")
    private TradeTypeEnum tradeType;

    /**
     * 回调地址
     */
    @Element(name="notify_url")
    private String notifyUrl;

    /**
     * 校验必填参数是否缺失的方法
     */
    @Override
    public void validate() {
        Assert.hasText(this.getAppid(), "APPID缺失");
        Assert.hasText(this.getMchId(), "商户号【mchId】缺失");
        Assert.hasText(this.getNonceStr(), "随机字符串【nonceStr】缺失");
        Assert.hasText(this.getSpbillCreateIp(), "终端IP【spbillCreateIp】缺失");
        Assert.hasText(this.getSubject(), "订单描述【subject】缺失");
        Assert.hasText(this.getOutTradeNo(), "订单号【outTradeNo】缺失");
        Assert.notNull(this.getTotalAmount(), "订单总金额【totalAmount】缺失");
        Assert.notNull(this.getTradeType(), "支付类型【tradeType】缺失");
        Assert.hasText(this.getNotifyUrl(), "回调地址【notifyUrl】缺失");
    }

    //    private WechatPromotionDetail detail;
}
