package com.github.zeemood.wechat.pay.annotation;

import com.github.zeemood.wechat.pay.config.MobileAppPayAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 开启APP微信支付
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 17:13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MobileAppPayAutoConfiguration.class)
public @interface EnableWechatMobileAppAndNativePay {
}
