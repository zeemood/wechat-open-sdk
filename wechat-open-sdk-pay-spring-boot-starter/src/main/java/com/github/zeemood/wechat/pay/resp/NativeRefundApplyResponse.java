package com.github.zeemood.wechat.pay.resp;

import lombok.Data;
import org.simpleframework.xml.Root;

/**
 * <p>
 * 退款申请
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 1:50
 */
@Data
@Root(name = "xml")
public class NativeRefundApplyResponse extends MobileAppRefundApplyResponse {
}
