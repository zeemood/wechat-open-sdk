package com.github.zeemood.wechat.login.config.webapp;

import com.github.zeemood.wechat.login.service.impl.WebAppLoginServiceImpl;
import com.github.zeemood.wechat.common.config.webapp.WebAppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信网页登录自动装配类
 *
 * @author zhang.shushan
 * @date 2019/4/28
 */
@Configuration
@EnableConfigurationProperties(WebAppProperties.class)
public class WebAppLoginAutoConfiguration {

    @Autowired
    private WebAppProperties webAppProperties;

    @Bean
    public WebAppLoginServiceImpl webAppLoginService(){
        WebAppLoginServiceImpl service = new WebAppLoginServiceImpl();
        service.setProperties(webAppProperties);
        return service;
    }
}
