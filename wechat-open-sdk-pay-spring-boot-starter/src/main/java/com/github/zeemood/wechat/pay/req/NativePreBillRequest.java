package com.github.zeemood.wechat.pay.req;

import lombok.Data;
import org.simpleframework.xml.Root;

/**
 * <p>
 * 生成二维码支付链接
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 1:39
 */
@Data
@Root(name = "xml")
public class NativePreBillRequest extends MobileAppPreBillRequest {

}
