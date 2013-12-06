package com.sarabadani.onlinecademy.service.user;

import com.sarabadani.commons.repository.UserRepository;
import com.sarabadani.onlinecademy.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Author: Soroosh Sarabadani
 * Date: 12/6/13
 * Time: 6:15 PM
 */
@Service("securityUserService")
public class SecurityUserService implements UserDetailsService {
    public SecurityUserService(){
        System.out.println("New UserService created.");
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User foundUser = userRepository.findByUsername(username);
        if (foundUser == null) {
            throw new UsernameNotFoundException(String.format("User with %s does not exist.", username));
        }
        return foundUser;
    }
}
