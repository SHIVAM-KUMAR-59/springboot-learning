package com.shivam._1.SpringBootJPA;

import com.shivam._1.SpringBootJPA.model.Student;
import com.shivam._1.SpringBootJPA.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepository repo = context.getBean(StudentRepository.class);

		Student s1 =  context.getBean(Student.class);
		Student s2 =  context.getBean(Student.class);
		Student s3 =  context.getBean(Student.class);

		s1.setRoll(101);
		s1.setName("First");
		s1.setMarks(89);

		s2.setRoll(102);
		s2.setName("Scond");
		s2.setMarks(79);

		s3.setRoll(103);
		s3.setName("Third");
		s3.setMarks(99);

		repo.save(s1);
		repo.save(s2);
		repo.save(s3);

		List<Student> students = repo.findAll();
		System.out.println(students);

		System.out.println(repo.findById(103));
	}

}
