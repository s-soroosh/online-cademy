package com.sarabadani.onlinecademy.model.user;

import com.sarabadani.onlinecademy.model.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * Created by soroosh on 12/5/13.
 */
@Embeddable
public class Authority implements GrantedAuthority {

    @Basic
    private final String authority;

    protected Authority() {
        this.authority = null;
    }

    public Authority(String authority) {
        Assert.notNull(authority, "authority name cannot be null.");
        Assert.hasText(authority, "authority cannot be empty.");
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority1 = (Authority) o;

        if (authority != null ? !authority.equals(authority1.authority) : authority1.authority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return authority != null ? authority.hashCode() : 0;
    }
}
