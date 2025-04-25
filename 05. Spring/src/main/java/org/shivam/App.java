package org.shivam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load Spring configuration from XML and object creation happens here
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // Creates a container

        // Get the bean from context
        Alien obj = (Alien) context.getBean("alien"); // Getting the object from spring
        obj.code();
    }
}
