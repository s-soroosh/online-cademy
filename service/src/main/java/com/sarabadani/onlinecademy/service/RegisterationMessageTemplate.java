package com.sarabadani.onlinecademy.service;

import com.sarabadani.onlinecademy.model.user.User;
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

    private final User user;

    public RegisterationMessageTemplate(User user) {

        this.user = user;
    }

    @Override
    public void prepare(MimeMessage mimeMessage) throws Exception {
        mimeMessage.setRecipients(Message.RecipientType.TO, user.getEmail());
        final String refinedMessage = MESSAGE.replace("{name}", user.getName()).replace("{lastName}", user.getLastName());
        mimeMessage.setContent(refinedMessage, "text/html");
    }
}
