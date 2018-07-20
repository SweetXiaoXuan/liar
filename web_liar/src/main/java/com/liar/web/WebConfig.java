package com.liar.web;

import com.liar.web.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liumengwe
 * @since 2018/7/10
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private RequestInterceptor requestInterceptor;
    private static List<String> NOT_INTERCEPT_URL = new ArrayList<>();
    private static List<String> INTERCEPT_URL = new ArrayList<>();
    static {
        NOT_INTERCEPT_URL.add("/fiction/{device}/index");
        INTERCEPT_URL.add("/**");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor)
                .addPathPatterns(INTERCEPT_URL)
                .excludePathPatterns(NOT_INTERCEPT_URL)
        ;
    }
}
