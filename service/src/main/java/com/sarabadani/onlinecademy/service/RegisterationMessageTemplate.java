package com.sarabadani.onlinecademy.service;

import com.sarabadani.onlinecademy.model.student.Student;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

/**
 * Author: Soroosh Sarabadani
 * Date: 3/8/13
 * Time: 7:46 PM
 */
public class RegisterationMessageTemplate implements MimeMessagePreparator {
    private static final String MESSAGE = "<p> Dear {name} {lastName}<br />" +
            "Welcome to Online ACademy.</p>";

    private final Student student;

    public RegisterationMessageTemplate(Student student) {

        this.student = student;
    }

    @Override
    public void prepare(MimeMessage mimeMessage) throws Exception {
        mimeMessage.setRecipients(Message.RecipientType.TO, student.getEmail());
        final String refinedMessage = MESSAGE.replace("{name}", student.getName()).replace("{lastName}", student.getLastName());
        mimeMessage.setContent(refinedMessage, "text/html");
    }
}
