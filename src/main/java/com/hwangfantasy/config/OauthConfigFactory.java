package com.hwangfantasy.config;

import com.hwangfantasy.service.MainService;
import com.hwangfantasy.service.QqService;
import com.hwangfantasy.service.impl.MainServiceImpl;
import com.hwangfantasy.service.impl.QqServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hwangfantasy
 * @since 2018/2/28
 */
@Configuration
public class OauthConfigFactory {
    @Autowired
    private OauthQqProperties qqProperties;

    @Bean
    public OauthQqConfig qqConfig() {
        return OauthQqConfig.OauthQqConfigBuilder.anOauthQqConfig()
                .withOpenId(this.qqProperties.getOpenId())
                .withOpenKey(this.qqProperties.getOpenKey())
                .withRedirect(this.qqProperties.getRedirect())
                .withAuthorizeUrl("https://graph.qq.com/oauth2.0/authorize")
                .withTokenUrl("https://graph.qq.com/oauth2.0/token")
                .withMeUrl("https://graph.qq.com/oauth2.0/me")
                .withUserInfoUrl("https://graph.qq.com/user/get_user_info")
                .build();
    }

    @Bean
    public QqService qqService() {
        QqService qqService = new QqServiceImpl();
        qqService.setConfig(qqConfig());
        return qqService;
    }


    @Bean
    public MainService mainService() {
        return new MainServiceImpl();
    }
}
