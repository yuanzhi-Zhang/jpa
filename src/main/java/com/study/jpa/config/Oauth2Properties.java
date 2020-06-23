package com.study.jpa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: 张远志
 * @Date: 2020/5/12 10:46
 */

@Component
@ConfigurationProperties(prefix = "github")
public class Oauth2Properties {

    @Value("${spring.security.oauth2.client.registration.github.clientId}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.github.clientSecret}")
    private String clientSecret;
    @Value("${spring.security.oauth2.client.registration.github.authorizeUrl}")
    private String authorizeUrl;
    @Value("${spring.security.oauth2.client.registration.github.redirectUrl}")
    private String redirectUrl;
    @Value("${spring.security.oauth2.client.registration.github.accessTokenUrl}")
    private String accessTokenUrl;
    @Value("${spring.security.oauth2.client.registration.github.userInfoUrl}")
    private String userInfoUrl;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }
}
