package com.demo.user.service;

import com.demo.user.model.User;
import com.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.NoSuchElementException;

@Service
public class CustomUserAuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(user == null){
            throw new NoSuchElementException("user not found!!");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }
}
