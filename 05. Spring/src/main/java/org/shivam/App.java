package org.shivam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load Spring configuration from XML and object creation happens here for all the listen beans
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // Creates a container

        // Get the bean from context
        Alien obj = (Alien) context.getBean("alien"); // Getting the object from spring
        // obj.setAge(21);
        System.out.println(obj.getAge());
        obj.code();

        /*
        Alien obj1 = (Alien) context.getBean("alien"); // Getting the object from spring
        System.out.println(obj1.age); // This will also print 20 since same object
        obj1.code();
         */
    }
}
