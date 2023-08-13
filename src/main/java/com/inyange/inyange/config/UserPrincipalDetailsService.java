package com.inyange.inyange.config;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inyange.inyange.model.User;
import com.inyange.inyange.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;



    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }



}

