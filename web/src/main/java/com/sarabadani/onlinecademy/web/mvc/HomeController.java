package com.sarabadani.onlinecademy.web.mvc;

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
        return "Index";
    }
}
