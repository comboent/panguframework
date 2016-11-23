package org.panguframework.shiro.realm;

import com.zyt.catarc.enterprise.shiro.token.StatelessToken;
import com.zyt.catarc.enterprise.support.auth.Token;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class StatelessRealm extends AuthorizingRealm {

    private CacheManager userTokenCacheManager;

    public CacheManager getUserTokenCacheManager() {
        return userTokenCacheManager;
    }

    public void setUserTokenCacheManager(CacheManager userTokenCacheManager) {
        this.userTokenCacheManager = userTokenCacheManager;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof StatelessToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Cache<String, Token> cache = userTokenCacheManager.getCache("user.token");
        String principal = (String) authenticationToken.getPrincipal();
        Token token = cache.get(principal);
        if (token == null) {
            throw new AuthenticationException();
        }

        return new SimpleAuthenticationInfo(principal, authenticationToken.getCredentials(), getName());


    }
}
