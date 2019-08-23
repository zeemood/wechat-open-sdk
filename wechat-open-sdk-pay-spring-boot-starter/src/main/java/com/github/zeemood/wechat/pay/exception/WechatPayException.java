package com.github.zeemood.wechat.pay.exception;

import com.github.zeemood.wechat.pay.enums.WechatPayResultEnum;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zeemoo
 * @since 2019/7/16 0:07
 */
@Getter
@Slf4j
public class WechatPayException extends RuntimeException {
    public WechatPayException(WechatPayResultEnum err) {
        super(err.getDesc());
        log.error("【微信支付异常】code=%s,异常信息：%s", err.getCode(), err.getDesc());
    }

    public WechatPayException(String tpl, Object... args) {
        super(String.format(tpl, args));
        log.error(super.getMessage());
    }
}
