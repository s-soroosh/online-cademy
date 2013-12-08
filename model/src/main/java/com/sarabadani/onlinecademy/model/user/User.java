package com.sarabadani.onlinecademy.model.user;

import com.sarabadani.onlinecademy.model.Entity;
import com.sarabadani.onlinecademy.model.student.Grade;
import com.sarabadani.onlinecademy.model.student.StudentBlockedException;
import org.hibernate.annotations.Index;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.*;

/**
 * Created by soroosh on 12/5/13.
 */
@javax.persistence.Entity
public class User extends Entity implements UserDetails {

    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_AUTHORITY",
            joinColumns = @JoinColumn(name = "USER_ID"), uniqueConstraints = @UniqueConstraint(columnNames = {"USER_ID", "AUTHORITY"}))
    private List<GrantedAuthority> authorities;
    @Column()
    private String password;
    @Column(unique = true, updatable = false)
    private String username;

    @Column
    private Boolean enabled;

    private final String verificationCode;

    private String name;
    private String lastName;
    @Column(unique = true, nullable = false, updatable = false)
    @Index(name = "student_email_index")
    private String email;
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    @Enumerated(EnumType.STRING)
    private UserStatus status;


    protected User() {
        this.verificationCode = null;
    }

    public User(String username, String password, String name, String lastName, String email, Date birthDate, Grade grade) {
        authorities = new ArrayList<GrantedAuthority>();
        this.username = username;
        this.password = password;
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
        this.status = UserStatus.PENDING;
        this.enabled = true;
    }

    public void verify(String verificationCode) {
        if (! this.enabled) {
            throw new StudentBlockedException(String.format("User with id:%s is blocked so can't verify its account.", this.getId()));
        }
        if (this.verificationCode.equals(verificationCode)) {
            this.status = UserStatus.VERIFIED;
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
        if (this.status == UserStatus.VERIFIED)
            return true;
        else
            return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void addAuthority(String authority) {
        authorities.add(new Authority(authority));
    }
}
