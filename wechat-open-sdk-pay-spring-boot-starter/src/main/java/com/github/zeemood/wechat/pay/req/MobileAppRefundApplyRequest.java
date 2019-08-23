package com.github.zeemood.wechat.pay.req;

import lombok.Data;
import org.simpleframework.xml.Root;

/**
 * <p>
 * App退款申请信息
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/18 0:22
 */
@Data
@Root(name = "xml")
public class MobileAppRefundApplyRequest extends RefundApplyRequest {

}
