package com.sarabadani.onlinecademy.model.student;

import org.hibernate.annotations.Index;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author: Soroosh Sarabadani
 * Date: 3/3/13
 * Time: 8:01 AM
 */
@Entity
public class Student {

    private final String verificationCode;
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    @Column(unique = true, nullable = false, updatable = false)
    @Index(name = "student_email_index")
    private String email;
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    protected Student() {
        this.verificationCode = null;
    }

    public Student(String name, String lastName, String email, Date birthDate, Grade grade) {
        Assert.notNull(name, "name cannot be null");
        Assert.hasText(name, "name cannot be empty");
        Assert.notNull(lastName, "lastName cannot be null");
        Assert.hasText(lastName, "lastName cannot be empty");
        Assert.notNull(email, "email cannot be null");
        Assert.hasText(email, "email cannot be empty");
        Assert.notNull(birthDate, "birthDate cannot be null");
        Assert.notNull(grade, "grade cannot be null");
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = new Date(birthDate.getTime());
        this.grade = grade;
        this.verificationCode = UUID.randomUUID().toString();
        this.status = StudentStatus.PENDING;

    }

    public Long getId() {
        return id;
    }

    public void verify(String verificationCode) {
        if (this.status == StudentStatus.BLOCKED) {
            throw new StudentBlockedException(String.format("Student with id:%s is blocked so can't verify its account.", this.id));
        }
        if (this.verificationCode.equals(verificationCode)) {
            this.status = StudentStatus.VERIFIED;
        } else {
            throw new IllegalArgumentException("verificationCode is not ok.");
        }
    }

    //region getters
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Grade getGrade() {
        return grade;
    }

    public String getVerificationCode() {
        return verificationCode;
    }
    //endregion
}
