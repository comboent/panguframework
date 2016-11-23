package org.panguframework.shiro.filter;

import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StatelessAuthcFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        Map parameterMap = servletRequest.getParameterMap();
//        if(parameterMap.containsKey("wsdl")) {
//            return true;
//        }
//        ServletInputStream in = servletRequest.getInputStream();
//        Reader r = new InputStreamReader(in);
//        BufferedReader reader = new BufferedReader(r);
//        StringBuffer buffer = new StringBuffer();
//
//        String tmp;
//        while ((tmp = reader.readLine()) != null) {
//            buffer.append(tmp);
//        }
//        String payload = buffer.toString();
//        Document doc = SoapUtils.parsePayload(payload);
//        String token = SoapUtils.parseToken(doc);
//        String method = SoapUtils.parseRequestMethodName(doc);
//        if(StringUtils.isEmpty(method)) {
//            return false;
//        }
//        if(StringUtils.isEmpty(token) && StringUtils.equals(method, "login")) {
//            return true;
//        }
//        StatelessToken statelessToken = new StatelessToken(token);
//        try {
//            Subject subject = getSubject(servletRequest, servletResponse);
//            subject.login(statelessToken);
//        } catch (AuthenticationException e) {
//            BusinessException be = new BusinessException(ErrorCode.AUTHENTICATION_ERR, MsgProvider.getMsg("err.authentication.fail.auth.token.not.found.or.expired"));
//            String authFailPayload = SoapUtils.createSoapPayload(method, Response.createErrResponse().businessErr(be));
//            servletResponse.getWriter().println(authFailPayload);
//            servletResponse.setContentType("text/xml");
//            return false;
//        }
        return true;
    }
}
