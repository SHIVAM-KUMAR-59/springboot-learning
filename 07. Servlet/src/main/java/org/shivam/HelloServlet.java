package org.shivam;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// HttpServlet is a class which we need to extend
public class HelloServlet extends HttpServlet {

    // service() is an important method for servlets to work
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("In service");

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<h2><b>Hello world</b></h2>");
    }
}
