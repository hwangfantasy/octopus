package com.hwangfantasy.service.impl;

import com.hwangfantasy.config.OauthQqConfig;
import com.hwangfantasy.service.QqService;

/**
 *
 * @author hwangfantasy
 * @since 2018/2/28
 */
public class QqServiceImpl implements QqService {

    private OauthQqConfig qqConfig;

    @Override
    public OauthQqConfig getConfig() {
        return qqConfig;
    }

    @Override
    public void setConfig(OauthQqConfig qqConfig) {
        this.qqConfig = qqConfig;
    }
}
