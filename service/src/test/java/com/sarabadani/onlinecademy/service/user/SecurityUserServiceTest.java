package com.sarabadani.onlinecademy.service.user;

import com.sarabadani.commons.repository.UserRepository;
import com.sarabadani.onlinecademy.model.student.Grade;
import com.sarabadani.onlinecademy.model.user.User;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Date;

/**
 * Author: Soroosh Sarabadani
 * Date: 12/6/13
 * Time: 6:40 PM
 */
@ContextConfiguration(locations = "classpath*:service-context.xml")
public class SecurityUserServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private SecurityUserService userService;

    @Autowired
    private UserRepository userRepository;

    @Before
    public  void before(){
        User user = new User("soroosh","123456","name","lastName","email",new Date(), Grade.ASSOCIATE);
        userRepository.saveAndFlush(user);

    }

    @After
    public void after(){
        userRepository.deleteAllInBatch();
    }

    @Test
    public void should_find_user_soroosh(){
        final UserDetails soroosh = userService.loadUserByUsername("soroosh");
        Assert.assertNotNull(soroosh);

    }

    @Test(expected = UsernameNotFoundException.class)
    public void should_throw_exception_when_user_does_not_exist(){
        userService.loadUserByUsername("xxx") ;
    }
}
