package com.github.zeemood.wechat.login.exception;

import lombok.Data;

/**
 * @author zhang.shushan
 * @date 2019/4/29
 */
@Data
public class WechatLoginRespException extends RuntimeException {
    private static final long serialVersionUID = -5035018726425963469L;

    public WechatLoginRespException(String reasonPhrase) {
        super(reasonPhrase);
    }
}
