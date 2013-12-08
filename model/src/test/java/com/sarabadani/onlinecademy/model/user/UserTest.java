package com.sarabadani.onlinecademy.model.user;

import com.sarabadani.onlinecademy.model.student.Grade;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by soroosh on 12/5/13.
 */
public class UserTest {

    public static final String ADMIN = "Admin";
    public static final String NAME = "name";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final Date BIRTH_DATE = new Date();
    public static final Grade ASSOCIATE = Grade.ASSOCIATE;
    public static final String USERNAME = "soroosh";
    public static final String PASSWORD = "123";

    @Test
    public void addAuthority_should_add_new_authority_to_user() {
        User user = new User(USERNAME, PASSWORD, NAME, LAST_NAME, EMAIL, BIRTH_DATE, ASSOCIATE);
        user.addAuthority(ADMIN);

        Assert.assertTrue(user.getAuthorities().size() == 1);
        Assert.assertEquals(user.getAuthorities().iterator().next().getAuthority(), ADMIN);
        Assert.assertEquals(NAME, user.getName());
        Assert.assertEquals(LAST_NAME, user.getLastName());
        Assert.assertEquals(EMAIL, user.getEmail());
        Assert.assertEquals(BIRTH_DATE, user.getBirthDate());
        Assert.assertEquals(ASSOCIATE, user.getGrade());

    }


    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_name_is_empty() {
        new User(USERNAME,PASSWORD, "", LAST_NAME, EMAIL, BIRTH_DATE, ASSOCIATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_name_is_null() {
        new User(USERNAME,PASSWORD,null, LAST_NAME, EMAIL, BIRTH_DATE, ASSOCIATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_lastName_is_empty() {
        new User(USERNAME,PASSWORD,NAME, "", EMAIL, BIRTH_DATE, ASSOCIATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_lastName_is_null() {
        new User(USERNAME,PASSWORD,NAME, null, EMAIL, BIRTH_DATE, ASSOCIATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_email_is_empty() {
        new User(USERNAME,PASSWORD,NAME, LAST_NAME, "", BIRTH_DATE, ASSOCIATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_email_is_null() {
        new User(USERNAME,PASSWORD,NAME, LAST_NAME, null, BIRTH_DATE, ASSOCIATE);
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_birthDate_is_null() {
        new User(USERNAME,PASSWORD,NAME, LAST_NAME, EMAIL, null, ASSOCIATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_should_throw_exception_when_grade_is_null() {
        new User(USERNAME,PASSWORD,NAME, LAST_NAME, EMAIL, BIRTH_DATE, null);
    }

}
