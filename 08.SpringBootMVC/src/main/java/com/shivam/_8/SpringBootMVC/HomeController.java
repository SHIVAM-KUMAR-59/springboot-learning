package com.shivam._8.SpringBootMVC;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Making a controller (converts this into servlets)
public class HomeController {

    @RequestMapping("/") // Maps the method to / request
    public String home(){
        System.out.println("Home called");
        return "index.jsp";
    }

}
