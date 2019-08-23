package com.github.zeemood.wechat.pay.resp;

import lombok.Data;
import org.simpleframework.xml.Root;

/**
 * <p>
 * 退款申请信息返回类
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/18 0:23
 */
@Data
@Root(name = "xml")
public class MobileAppRefundApplyResponse extends RefundApplyReponse {
}
