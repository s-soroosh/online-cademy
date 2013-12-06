package com.sarabadani.onlinecademy.web.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/2/13
 * Time: 3:43 PM
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()) System.out.println(authentication.getPrincipal());
        return "Index";
    }
}

