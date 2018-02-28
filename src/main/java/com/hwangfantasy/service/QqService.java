package com.hwangfantasy.service;


import com.hwangfantasy.config.OauthQqConfig;

/**
 * @author hwangfantasy
 * @since 2018/2/28
 */
public interface QqService {
    /**
     * 获取认证配置
     *
     * @return null
     */
    OauthQqConfig getConfig();

    /**
     * 设置配置
     *
     * @param qqConfig
     */
    void setConfig(OauthQqConfig qqConfig);

    String authorize();
}
