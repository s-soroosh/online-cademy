package com.sarabadani.onlinecademy.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by soroosh on 12/11/13.
 */
public class LoginFailedInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LoginFailedInterceptor.class);

    String createMessageFromError(AuthenticationException exception){
        if(exception instanceof BadCredentialsException){
            return "user.credential";
        }
        else if (exception instanceof LockedException){
            return "user.disable";
        }
        else if (exception instanceof DisabledException)  {
            return "user.locked";
        }
        else{
            logger.error(exception.getClass().getName() + " occured");
            return "user.unknown";
        }

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object lastException =  request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if(lastException != null) {
            request.setAttribute("error",createMessageFromError((AuthenticationException)lastException));
//            model.addAttribute("error",createMessageFromError((AuthenticationException)lastException));
            request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
        else{
            request.setAttribute("error","");

        }

        //proceed any case
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
