package com.github.zeemood.wechat.pay.resp;

import lombok.Data;
import org.simpleframework.xml.Root;

/**
 * <p>
 * 微信公众号退款申请返回
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 15:30
 */
@Data
@Root(name = "xml")
public class JsapiRefundApplyResponse extends RefundApplyReponse {
}
