package com.sarabadani.onlinecademy.web.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 12/2/13
 * Time: 1:02 PM
 */

public class MenuInterceptor implements WebRequestInterceptor {

    private Logger logger = LoggerFactory.getLogger(MenuInterceptor.class);

    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {


        logger.info("Post handling of the request");
        if (modelMap != null) {
            List<String> mockMenu = new ArrayList<String>();
            mockMenu.add("Test1");
            mockMenu.add("Test3");
            modelMap.addAttribute("menu", mockMenu);
        }
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
