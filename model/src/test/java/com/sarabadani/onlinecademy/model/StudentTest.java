package com.sarabadani.onlinecademy.model;//import org.slf4j.Logger;

import com.sarabadani.onlinecademy.model.student.Grade;
import com.sarabadani.onlinecademy.model.student.Student;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author: Soroosh Sarabadani
 * Date: 3/3/13
 * Time: 8:08 AM
 */

public class StudentTest {

    public static final String NAME = "name";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email@email.com";
    public static final Date BIRTH_DATE = new Date();
    public static final Grade MASTER = Grade.MASTER;

    @Test
    public void constructor_should_create_new_student() {
        final Student student = new Student(NAME, LAST_NAME, EMAIL, BIRTH_DATE, MASTER);
        Assert.assertEquals(NAME, student.getName());
        Assert.assertEquals(LAST_NAME, student.getLastName());
        Assert.assertEquals(EMAIL, student.getEmail());
        Assert.assertEquals(BIRTH_DATE, student.getBirthDate());
        Assert.assertEquals(MASTER, student.getGrade());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_name_is_empty() {
        new Student("", LAST_NAME, EMAIL, BIRTH_DATE, MASTER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_name_is_null() {
        new Student(null, LAST_NAME, EMAIL, BIRTH_DATE, MASTER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_lastName_is_empty() {
        new Student(NAME, "", EMAIL, BIRTH_DATE, MASTER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_lastName_is_null() {
        new Student(NAME, null, EMAIL, BIRTH_DATE, MASTER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_email_is_empty() {
        new Student(NAME, LAST_NAME, "", BIRTH_DATE, MASTER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_email_is_null() {
        new Student(NAME, LAST_NAME, null, BIRTH_DATE, MASTER);
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_birthDate_is_null() {
        new Student(NAME, LAST_NAME, EMAIL, null, MASTER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_grade_is_null() {
        new Student(NAME, LAST_NAME, EMAIL, BIRTH_DATE, null);
    }

}
