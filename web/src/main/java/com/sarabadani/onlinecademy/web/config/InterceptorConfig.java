package com.sarabadani.onlinecademy.web.config;

import com.sarabadani.onlinecademy.web.interceptor.CurretUrlSetterInterceptor;
import com.sarabadani.onlinecademy.web.interceptor.LoginFailedInterceptor;
import com.sarabadani.onlinecademy.web.interceptor.MenuInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: Soroosh Sarabadani
 * Date: 12/2/13
 * Time: 2:48 PM
 */

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(currentUrlSetterInterceptor());
        registry.addInterceptor(loginFailedInterceptor());
        registry.addWebRequestInterceptor(menuInterceptor());
    }

    private HandlerInterceptor currentUrlSetterInterceptor() {
        return new CurretUrlSetterInterceptor();
    }

    @Bean
    public WebRequestInterceptor menuInterceptor() {
        return new MenuInterceptor();
    }

    @Bean
    HandlerInterceptor loginFailedInterceptor(){
        return new LoginFailedInterceptor();
    }
}
