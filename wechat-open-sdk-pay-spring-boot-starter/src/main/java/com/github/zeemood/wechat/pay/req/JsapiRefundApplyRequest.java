package com.github.zeemood.wechat.pay.req;

import lombok.Data;
import org.simpleframework.xml.Root;

/**
 * <p>
 * 退款申请类
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 15:25
 */
@Data
@Root(name = "xml")
public class JsapiRefundApplyRequest extends RefundApplyRequest {
}
