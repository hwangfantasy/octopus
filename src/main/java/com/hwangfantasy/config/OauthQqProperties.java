package com.hwangfantasy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author hwangfantasy
 * @since  2018/2/28
 */
@Component
@ConfigurationProperties(prefix = "qq")
public class OauthQqProperties extends AbstractOauthProperties {
}
