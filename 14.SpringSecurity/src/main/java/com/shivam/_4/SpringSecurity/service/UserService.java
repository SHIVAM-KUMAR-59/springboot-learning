package com.shivam._4.SpringSecurity.service;

import com.shivam._4.SpringSecurity.model.Users;
import com.shivam._4.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public Users saveUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
