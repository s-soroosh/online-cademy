package com.sarabadani.onlinecademy.web.mvc;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/2/13
 * Time: 3:43 PM
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(HttpServletRequest request,HttpServletResponse response,ModelMap model) {
        Object lastException =  request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if(lastException != null) {

            model.addAttribute("error",createMessageFromError((AuthenticationException)lastException));
            request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
        else{
            model.addAttribute("error","");
        }

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()) System.out.println(authentication.getPrincipal());
        return "Index";
    }

    String createMessageFromError(AuthenticationException exception){
        if(exception instanceof BadCredentialsException){
            return "user.credential";
        }
        else if (exception instanceof LockedException){
            return "user.disable";
        }
        else if (exception instanceof DisabledException)  {
            return "user.blocked";
        }
        else{
           return "user.unknown";
        }
       /* else {
            return "other issues";
        }*/

    }
}

