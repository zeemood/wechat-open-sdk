package com.github.zeemood.wechat.pay.resp;

import lombok.Data;
import org.simpleframework.xml.Root;

/**
 * <p>
 * 统一下单返回类
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 14:24
 */
@Data
@Root(name = "xml")
public class JsapiPreBillResponse extends PreBillResponse {
}
