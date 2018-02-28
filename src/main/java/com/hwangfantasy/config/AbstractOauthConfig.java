package com.hwangfantasy.config;

/**
 * @author hwangfantasy
 * @since 2018/2/28
 */
abstract class AbstractOauthConfig {
    /**
     * 开放ID
     */
    private String openId;
    /**
     * 开放密钥
     */
    private String openKey;
    /**
     * 回调地址
     */
    private String redirect;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenKey() {
        return openKey;
    }

    public void setOpenKey(String openKey) {
        this.openKey = openKey;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    @Override
    public String toString() {
        return "AbstractOauthConfig{" +
                "openId='" + openId + '\'' +
                ", openKey='" + openKey + '\'' +
                ", redirect='" + redirect + '\'' +
                '}';
    }
}
