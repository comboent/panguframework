package org.panguframework.shiro.filter;

import org.apache.shiro.web.servlet.OncePerRequestFilter;
import org.panguframework.shiro.http.CopyOnReadHttpServletRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class WrapRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        ServletRequest reqWrapper = null;
        if(servletRequest instanceof HttpServletRequest) {
            reqWrapper = new CopyOnReadHttpServletRequestWrapper((HttpServletRequest)servletRequest);
        }

        if(reqWrapper == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(reqWrapper, servletResponse);
        }
    }
}
