package com.sarabadani.onlinecademy.service;//import org.slf4j.Logger;
//import com.samenea.commons.component.utils.log.LoggerFactory;

import com.sarabadani.commons.repository.StudentRepository;
import com.sarabadani.onlinecademy.model.student.Grade;
import com.sarabadani.onlinecademy.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Date;

/**
 * @author: Soroosh Sarabadani
 * Date: 3/3/13
 * Time: 4:46 PM
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Transactional
    public String register(String name, String lastName, String email, Date birthDate, Grade grade) {
        Student student = new Student(name, lastName, email, birthDate, grade);
        student = studentRepository.save(student);
        mailSender.send(new RegisterationMessageTemplate(student));
        return student.getId().toString();
    }
    @Override
    @Transactional
    public void verify(Long studentId, String verificationCode) {

        final Student student = studentRepository.findOne(studentId);
        student.verify(verificationCode);
    }
}
