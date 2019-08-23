package com.github.zeemood.wechat.pay.req;

import lombok.Data;
import org.simpleframework.xml.Root;

/**
 * <p>
 * 退款申请
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 1:49
 */
@Data
@Root(name = "xml")
public class NativeRefundApplyRequest extends MobileAppRefundApplyRequest {
}
