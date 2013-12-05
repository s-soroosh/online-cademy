package com.sarabadani.onlinecademy.model.user;

import org.junit.Test;

/**
 * Created by soroosh on 12/5/13.
 */
public class AuthorityTest {

    @Test(expected = IllegalArgumentException.class)
    public void authority_with_null_cannot_be_create(){
        Authority auth = new Authority(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void authority_with_empty_text_cannot_be_create(){
        Authority auth = new Authority("");
    }
}
