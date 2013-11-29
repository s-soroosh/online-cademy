package com.sarabadani.onlinecademy.service;

import com.sarabadani.onlinecademy.model.student.Grade;
import com.sarabadani.onlinecademy.model.student.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.Date;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/8/13
 * Time: 7:36 PM
 */
@ContextConfiguration("classpath*:service-context.xml")
public class StudentServiceImplTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    StudentService studentService;

    @Test
    @Ignore
    public void register_should_save_student() {
        String s = studentService.register("soroosh", "sarabadani", "soroosh.sarabadani@gmail.com", new Date(), Grade.MASTER);
        System.out.println(s);

    }

    @Test
    @Ignore
    public void verify_should_change_the_status_for_pending_to_verified(){
        studentService.verify(1L,"42ea3a02-6ee7-4828-a875-81bc144ac1fa");
    }
}
