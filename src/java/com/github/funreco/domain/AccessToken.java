package com.github.funreco.domain;

import java.util.Date;

public class AccessToken {
    private Date createdAt;

    /**
     * Domain with which this token was generated
     */
    private String domain;

    private String value;

    private boolean extended;

    public AccessToken() {
    }

    public static AccessToken fromDomainAndValue(String domain, String value) {
        AccessToken token = new AccessToken();

        token.domain = domain;
        token.value = value;
        token.createdAt = new Date();

        return token;
    }

    public String getDomain() {
        return domain;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getValue() {
        return value;
    }

    public boolean isExtended() {
        return extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }
}
