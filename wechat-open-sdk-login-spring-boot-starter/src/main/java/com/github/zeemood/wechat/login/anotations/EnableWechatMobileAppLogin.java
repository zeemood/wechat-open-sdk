package com.github.zeemood.wechat.login.anotations;

import com.github.zeemood.wechat.login.config.mobileapp.MobileAppLoginAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启移动app微信登录的配置
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MobileAppLoginAutoConfiguration.class)
public @interface EnableWechatMobileAppLogin {
}
