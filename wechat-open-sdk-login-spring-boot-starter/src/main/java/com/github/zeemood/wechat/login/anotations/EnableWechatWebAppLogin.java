package com.github.zeemood.wechat.login.anotations;

import com.github.zeemood.wechat.login.config.webapp.WebAppLoginAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启微信登录类
 *
 * @author zhang.shushan
 * @date 2019/4/28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(WebAppLoginAutoConfiguration.class)
public @interface EnableWechatWebAppLogin {
}
