package com.sarabadani.onlinecademy.model.user;

import com.sarabadani.onlinecademy.model.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by soroosh on 12/5/13.
 */
@javax.persistence.Entity
public class User extends Entity implements UserDetails {

    //    @OneToMany(targetEntity = Authority.class,cascade = CascadeType.ALL)
    @ElementCollection(targetClass = Authority.class)
    @CollectionTable(name = "USER_AUTHORITY",
            joinColumns = @JoinColumn(name = "USER_ID"),uniqueConstraints = @UniqueConstraint(columnNames = {"USER_ID","AUTHORITY"}))
    private List<GrantedAuthority> authorities;
    @Column()
    private String password;
    @Column(unique = true, updatable = false)
    private String username;


    protected User() {
    }

    public User(String username, String password) {
        authorities = new ArrayList<GrantedAuthority>();
        this.username = username;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void addAuthority(String authority) {
        authorities.add(new Authority(authority));
    }
}
