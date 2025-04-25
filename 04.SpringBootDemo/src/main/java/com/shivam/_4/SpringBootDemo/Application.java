package com.shivam._4.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// The run method returns the ApplicationContext object
		ApplicationContext context = SpringApplication.run(Application.class, args);

		// Alien obj = new Alien(); --> Conventional way of creating objects
		Alien obj = context.getBean(Alien.class); // getBean retrieves the object of that class from the IOC container
		obj.code();

		Alien obj1 = context.getBean(Alien.class);
		obj1.code();
	}

}
