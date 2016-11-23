package org.panguframework.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

public class StatelessToken implements AuthenticationToken {
    private String tokenId;

    public StatelessToken(String tokenId) {
        this.tokenId = tokenId;
    }

    @Override
    public Object getPrincipal() {
        return tokenId;
    }

    @Override
    public Object getCredentials() {
        return tokenId;
    }
}
