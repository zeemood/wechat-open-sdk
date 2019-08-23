package com.github.zeemood.wechat.pay.resp;

import com.github.zeemood.wechat.pay.enums.ResultEnum;
import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <p>
 * 通用结果返回类
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/17 22:25
 */
@Data
@Root(name = "xml")
public class BaseResponse {

    @Element(name = "return_code")
    private ResultEnum returnCode;

    @Element(name = "return_msg")
    private String returnMsg;

    @Element(name = "result_code", required = false)
    private ResultEnum resultCode;

    @Element(name = "err_code", required = false)
    private String errCode;

    @Element(name = "err_code_des", required = false)
    private String errCodeDes;
}
