package com.github.zeemood.wechat.pay.config;

import com.github.zeemood.wechat.common.config.mp.MpProperties;
import com.github.zeemood.wechat.pay.service.impl.JsapiBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * JSAPI自动装配
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 20:13
 */
@Configuration
@EnableConfigurationProperties(MpProperties.class)
public class JSAPIPayAutoConfiguration {

    @Autowired
    private MpProperties properties;

    @Bean
    public JsapiBusinessService jsapiBusinessService() {
        JsapiBusinessService jsapiBusinessService = new JsapiBusinessService();
        jsapiBusinessService.setProperties(properties);
        return jsapiBusinessService;
    }
}
