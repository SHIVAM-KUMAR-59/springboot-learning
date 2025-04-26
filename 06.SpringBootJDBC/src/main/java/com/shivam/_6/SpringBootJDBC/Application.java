package com.shivam._6.SpringBootJDBC;

import com.shivam._6.SpringBootJDBC.model.Student;
import com.shivam._6.SpringBootJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		Student student = context.getBean(Student.class);
		student.setRoll(104);
		student.setName("Shivam");
		student.setMarks(68);

		StudentService service = context.getBean(StudentService.class);

		service.addStudent(student);
		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
