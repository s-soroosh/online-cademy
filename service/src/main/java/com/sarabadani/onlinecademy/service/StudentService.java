package com.sarabadani.onlinecademy.service;//import org.slf4j.Logger;

import com.sarabadani.onlinecademy.model.student.Grade;

import java.util.Date;

/**
 * @author: Soroosh Sarabadani
 * Date: 3/3/13
 * Time: 4:45 PM
 */

public interface StudentService {
    String register(String name, String lastName, String email, Date birthDate, Grade grade);
    void verify(Long studentId, String verificationCode);
}
