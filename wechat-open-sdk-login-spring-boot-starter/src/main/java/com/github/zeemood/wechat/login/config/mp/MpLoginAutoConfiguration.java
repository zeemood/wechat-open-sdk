package com.github.zeemood.wechat.login.config.mp;

import com.github.zeemood.wechat.login.service.impl.MpLoginServiceImpl;
import com.github.zeemood.wechat.pay.common.config.mp.MpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 公众号登录自动配置类
 *
 * @author zhang.shushan
 * @date 2019/4/29
 */
@Configuration
@EnableConfigurationProperties(MpProperties.class)
public class MpLoginAutoConfiguration {

    @Autowired
    private MpProperties mpProperties;

    @Bean
    public MpLoginServiceImpl mpLoginService(){
        MpLoginServiceImpl service = new MpLoginServiceImpl();
        service.setProperties(mpProperties);
        return service;
    }
}
