package com.sarabadani.onlinecademy.web.config;

import com.sarabadani.onlinecademy.web.converter.DateConverter;
import com.sarabadani.onlinecademy.web.interceptors.MenuInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

import java.util.Date;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/2/13
 * Time: 3:21 PM
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sarabadani.onlinecademy.web.mvc"})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**/*", "/resources/**").addResourceLocations("/WEB-INF/web-resources/");
    }

}
