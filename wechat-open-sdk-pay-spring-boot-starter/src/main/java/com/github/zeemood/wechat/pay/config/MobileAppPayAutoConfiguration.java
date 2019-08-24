package com.github.zeemood.wechat.pay.config;

import com.github.zeemood.wechat.common.config.mobileapp.MobileAppProperties;
import com.github.zeemood.wechat.pay.service.impl.MobileAppBusinessService;
import com.github.zeemood.wechat.pay.service.impl.NativeBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 自动装配App支付
 * </p>
 *
 * @author zeemoo
 * @since 2019/8/24 17:14
 */
@Configuration
@EnableConfigurationProperties(MobileAppProperties.class)
public class MobileAppPayAutoConfiguration {
    @Autowired
    private MobileAppProperties mobileAppProperties;

    @Bean
    public MobileAppBusinessService mobileAppBusinessService() {
        MobileAppBusinessService mobileAppBusinessService = new MobileAppBusinessService();
        mobileAppBusinessService.setProperties(mobileAppProperties);
        return mobileAppBusinessService;
    }

    @Bean
    public NativeBusinessService nativeBusinessService() {
        NativeBusinessService nativeBusinessService = new NativeBusinessService();
        nativeBusinessService.setProperties(mobileAppProperties);
        return nativeBusinessService;
    }
}
