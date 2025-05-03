package com.shivam._4.SpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greet(HttpServletRequest request){
        System.out.println(request.getSession().getId());
        return "Hello World " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(){
        return "About page";
    }
}
