package com.sarabadani.onlinecademy.web.config;

import com.sarabadani.onlinecademy.web.interceptors.MenuInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequestInterceptor;
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
        registry.addWebRequestInterceptor(menuInterceptor());
    }

    @Bean
    public WebRequestInterceptor menuInterceptor() {
        return new MenuInterceptor();
    }
}
