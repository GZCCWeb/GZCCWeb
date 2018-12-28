package com.system.management.cofig;

import com.system.management.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源拦截器配置
 */
@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
        System.out.println("拦截器配置");
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
        //  放行
        interceptorRegistration.excludePathPatterns("/static/**");                                                      //  静态资源
        interceptorRegistration.excludePathPatterns("/logger/**");                                                      //  登陆登出日志
        interceptorRegistration.excludePathPatterns("/utils/**");                                                       //  工具
        //  拦截
        interceptorRegistration.addPathPatterns("/**");


    }
}
