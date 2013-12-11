package com.sarabadani.onlinecademy.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/2/13
 * Time: 3:21 PM
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sarabadani.onlinecademy.web.mvc"})
//@ImportResource({"classpath*:service-context.xml","classpath*:contexts/security.xml"})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("/WEB-INF/messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**/*", "/resources/**").addResourceLocations("/WEB-INF/web-resources/");
    }

}
