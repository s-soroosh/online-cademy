package com.sarabadani.onlinecademy.web.config;

import com.sarabadani.onlinecademy.web.converter.DateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;

/**
 * @author: Soroosh Sarabadani
 * Date: 12/2/13
 * Time: 2:52 PM
 */

@Configuration
public class FormatterConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter());
    }

    @Bean
    public Converter<String, Date> dateConverter() {
        return new DateConverter();
    }


}
