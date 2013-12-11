package com.sarabadani.onlinecademy.web.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by soroosh on 12/11/13.
 */
public class OnlinecademyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        saveException(request, exception);
        String path = request.getParameter("path");
        if(path == null){
            throw new IllegalStateException("Path must be set in calling authentication");
        }
        if(!path.startsWith("/")){
            throw new IllegalStateException("Path must be start with /");
        }


        response.sendRedirect(request.getContextPath()+path);

    }
}

