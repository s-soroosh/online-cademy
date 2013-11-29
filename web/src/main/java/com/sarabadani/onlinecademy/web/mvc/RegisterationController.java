package com.sarabadani.onlinecademy.web.mvc;

import com.sarabadani.onlinecademy.model.student.Grade;
import com.sarabadani.onlinecademy.model.student.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/15/13
 * Time: 2:32 PM
 */
@Controller
public class RegisterationController {
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap modelMap) {
        modelMap.addAttribute("grades", Grade.values());
        return "Register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(String name, String lastName, String email, Date birthDate, Grade grade) {
        Student student = new Student(name, lastName, email, birthDate, grade);
        System.out.println(student);

    }
}
