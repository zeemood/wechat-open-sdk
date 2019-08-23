package com.github.zeemood.wechat.pay.resp;

import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <p>
 *   退款通知返回类
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/23 21:48
 */
@Data
@Root(name="xml")
public class RefundResponse extends BaseResponse{

    @Element(required = false)
    private String appid;

    @Element(name="mch_id",required = false)
    private String mchId;

    @Element(name = "nonce_str")
    private String nonceStr;

    @Element(name = "req_info")
    private String reqInfo;
}
