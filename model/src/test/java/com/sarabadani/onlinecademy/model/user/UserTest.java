package com.sarabadani.onlinecademy.model.user;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by soroosh on 12/5/13.
 */
public class UserTest {

    public static final String ADMIN = "Admin";

    @Test
    public void addAuthority_should_add_new_authority_to_user() {
        User user = new User("soroosh","123");
        user.addAuthority(ADMIN);

        Assert.assertTrue(user.getAuthorities().size() == 1);
        Assert.assertEquals(user.getAuthorities().iterator().next().getAuthority(), ADMIN);

    }

}
