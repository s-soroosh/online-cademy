package com.sarabadani.onlinecademy.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * @author: Soroosh Sarabadani
 * Date: 12/2/13
 * Time: 2:15 PM
 */

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        String[] parts = s.split("/");

        final int year = Integer.parseInt(parts[0]);
        final int month = Integer.parseInt(parts[1]);
        final int days = Integer.parseInt(parts[2]);

        System.out.println("DateConverter:converting from "+s );

        return new Date(year, month, days);
    }
}
