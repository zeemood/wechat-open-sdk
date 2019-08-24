package com.github.zeemood.wechat.pay.annotation;

import com.github.zeemood.wechat.pay.config.JSAPIPayAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 开启jsapi支付
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 20:12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(JSAPIPayAutoConfiguration.class)
public @interface EnableWechatJSAPIPay {
}
