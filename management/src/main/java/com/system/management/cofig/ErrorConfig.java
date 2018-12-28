package com.system.management.cofig;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 实现ErrorPageRegistrar接口，定义具体异常的URL路径
 */
@Configuration
public class ErrorConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404Page");
        ErrorPage page403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403Page");
        ErrorPage page500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500Page");

        errorPageRegistry.addErrorPages(page404, page500, page403);
    }

    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new ErrorConfig();
    }
}

