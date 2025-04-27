package com.shivam._8.SpringBootMVC;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // Making a controller (converts this into servlets)
public class HomeController {

    @RequestMapping("/") // Maps the method to / request
    public String home(){
        System.out.println("Home called");
        // Return the page
        return "index";
    }

    /*
    --------------------------- Servlet Way ----------------------
    @RequestMapping("add")
    public String add(HttpServletRequest req, HttpSession session){

        int a = Integer.parseInt(req.getParameter("num1"));
        int b = Integer.parseInt(req.getParameter("num2"));
        int result = a + b;

        // Pass the data to the web page
        session.setAttribute("result", result);
        return "result";

    }
     */

    // --------------------------- SpringBoot Way ----------------------
    @RequestMapping("add")
    // num1 and num2 should be the same as the ones in the query parameter otherwise use @RequestParam(variable_name)
    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv){

        int result = num1 + num2;

        // Pass the data to the web page
        mv.addObject("result", result);

        // Set the page which needs to be called
        mv.setViewName("result");
        return mv;

    }
}
