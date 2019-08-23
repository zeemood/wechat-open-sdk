package com.github.zeemood.wechat.pay.resp;

import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <p>
 * 二维码支付链接返回类
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 1:41
 */
@Data
@Root(name = "xml")
public class NativePreBillResponse extends MobileAppPreBillResponse {
    @Element(name = "code_url", required = false)
    private String codeUrl;
}
