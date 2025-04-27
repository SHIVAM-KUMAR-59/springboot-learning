package com.shivam._8.SpringBootMVC;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Making a controller (converts this into servlets)
public class HomeController {

    @RequestMapping("/") // Maps the method to / request
    public String home(){
        System.out.println("Home called");
        return "index.jsp";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest req, HttpSession session){

        int a = Integer.parseInt(req.getParameter("num1"));
        int b = Integer.parseInt(req.getParameter("num2"));
        int result = a + b;

        // Pass the data to the web page
        session.setAttribute("result", result);
        return "result.jsp";

    }

}
