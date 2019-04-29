package com.github.zeemood.wechat.login.anotations;

import com.github.zeemood.wechat.login.config.mp.MpLoginAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 微信公众号登录
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MpLoginAutoConfiguration.class)
public @interface EnableWechatMpLogin {
}
