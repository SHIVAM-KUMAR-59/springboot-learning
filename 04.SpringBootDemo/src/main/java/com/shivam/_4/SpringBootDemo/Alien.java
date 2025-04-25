package com.shivam._4.SpringBootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Allows spring to create the object for this class
public class Alien {

    @Autowired
    Laptop laptop;

    public void code(){
        laptop.compile();
        System.out.println("Coding...");
    }
}
