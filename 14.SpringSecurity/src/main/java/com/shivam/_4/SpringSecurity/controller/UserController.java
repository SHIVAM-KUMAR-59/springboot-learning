package com.shivam._4.SpringSecurity.controller;

import com.shivam._4.SpringSecurity.model.Users;
import com.shivam._4.SpringSecurity.service.JWTService;
import com.shivam._4.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user){
        System.out.println(user);
        service.saveUser(user);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }else{
           return "Fail";
        }

    }
}
