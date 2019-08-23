package com.github.zeemood.wechat.pay.resp;

import com.github.zeemood.wechat.pay.enums.TradeTypeEnum;
import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/13 20:17
 */
@Data
@Root(name = "xml")
public class PreBillResponse extends BaseResponse {

    @Element(required = false)
    private String appid;

    @Element(name = "mch_id", required = false)
    private String mchId;

    @Element(name = "device_info", required = false)
    private String deviceInfo;

    @Element(name = "nonce_str", required = false)
    private String nonceStr;

    @Element(required = false)
    private String sign;

    @Element(name = "trade_type", required = false)
    private TradeTypeEnum tradeType;

    @Element(name = "prepay_id", required = false)
    private String prepayId;
}
