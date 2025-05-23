package com.shivam._4.SpringSecurity.service;

import com.shivam._4.SpringSecurity.model.UserPrinciple;
import com.shivam._4.SpringSecurity.model.Users;
import com.shivam._4.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repository.findByUsername(username);
        if(user == null){
            throw  new UsernameNotFoundException("user not found");
        }

        return new UserPrinciple(user);
    }

}
