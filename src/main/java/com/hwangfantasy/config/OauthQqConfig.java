package com.hwangfantasy.config;

/**
 * @author hwangfantasy
 * @since 2018/2/28
 */
public class OauthQqConfig extends AbstractOauthConfig {
    private String authorizeUrl;

    private String tokenUrl;

    private String meUrl;

    private String userInfoUrl;

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getMeUrl() {
        return meUrl;
    }

    public void setMeUrl(String meUrl) {
        this.meUrl = meUrl;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }


    public static final class OauthQqConfigBuilder {
        private String authorizeUrl;
        private String openId;
        private String tokenUrl;
        private String openKey;
        private String meUrl;
        private String userInfoUrl;
        private String redirect;

        private OauthQqConfigBuilder() {
        }

        public static OauthQqConfigBuilder anOauthQqConfig() {
            return new OauthQqConfigBuilder();
        }

        public OauthQqConfigBuilder withAuthorizeUrl(String authorizeUrl) {
            this.authorizeUrl = authorizeUrl;
            return this;
        }

        public OauthQqConfigBuilder withOpenId(String openId) {
            this.openId = openId;
            return this;
        }

        public OauthQqConfigBuilder withTokenUrl(String tokenUrl) {
            this.tokenUrl = tokenUrl;
            return this;
        }

        public OauthQqConfigBuilder withOpenKey(String openKey) {
            this.openKey = openKey;
            return this;
        }

        public OauthQqConfigBuilder withMeUrl(String meUrl) {
            this.meUrl = meUrl;
            return this;
        }

        public OauthQqConfigBuilder withUserInfoUrl(String userInfoUrl) {
            this.userInfoUrl = userInfoUrl;
            return this;
        }

        public OauthQqConfigBuilder withRedirect(String redirect) {
            this.redirect = redirect;
            return this;
        }

        public OauthQqConfig build() {
            OauthQqConfig oauthQqConfig = new OauthQqConfig();
            oauthQqConfig.setAuthorizeUrl(authorizeUrl);
            oauthQqConfig.setOpenId(openId);
            oauthQqConfig.setTokenUrl(tokenUrl);
            oauthQqConfig.setOpenKey(openKey);
            oauthQqConfig.setMeUrl(meUrl);
            oauthQqConfig.setUserInfoUrl(userInfoUrl);
            oauthQqConfig.setRedirect(redirect);
            return oauthQqConfig;
        }
    }

    @Override
    public String toString() {
        return "OauthQqConfig{" +
                "authorizeUrl='" + authorizeUrl + '\'' +
                ", tokenUrl='" + tokenUrl + '\'' +
                ", meUrl='" + meUrl + '\'' +
                ", userInfoUrl='" + userInfoUrl + '\'' +
                "} " + super.toString();
    }
}
