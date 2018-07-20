package com.liar.web.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liumengwe
 * @since 2018/7/10
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LogManager.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        request.setAttribute("userInfo", null);
        return true;
    }
}
