package com.sarabadani.commons.repository;

import com.sarabadani.onlinecademy.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by soroosh on 12/5/13.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
