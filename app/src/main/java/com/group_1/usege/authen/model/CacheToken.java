package com.group_1.usege.authen.model;

import com.group_1.usege.userInfo.model.UserInfo;

public class CacheToken {
    private String accessToken;
    private Integer expiresIn;
    private String refreshToken;
    private String idToken;

    public String getAccessToken() {
        return accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getIdToken() {
        return idToken;
    }
}
