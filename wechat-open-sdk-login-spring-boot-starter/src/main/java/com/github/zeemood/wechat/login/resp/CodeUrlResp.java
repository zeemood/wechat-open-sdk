package com.github.zeemood.wechat.login.resp;

import lombok.Data;

/**
 * 请求code的响应信息
 *
 * @author zhang.shushan
 * @date 2019/4/28
 */
@Data
public class CodeUrlResp {
    private String code;
    private String state;
}
