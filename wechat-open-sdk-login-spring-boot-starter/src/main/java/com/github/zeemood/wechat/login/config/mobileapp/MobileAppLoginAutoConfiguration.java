package com.github.zeemood.wechat.login.config.mobileapp;

import com.github.zeemood.wechat.common.config.mobileapp.MobileAppProperties;
import com.github.zeemood.wechat.login.service.impl.MobileAppLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 移动应用自动装配类
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
@Configuration
@EnableConfigurationProperties(MobileAppProperties.class)
public class MobileAppLoginAutoConfiguration {

    @Autowired
    private MobileAppProperties mobileAppProperties;

    @Bean
    public MobileAppLoginServiceImpl mobileAppLoginService(){
        MobileAppLoginServiceImpl service = new MobileAppLoginServiceImpl();
        service.setProperties(mobileAppProperties);
        return service;
    }
}
