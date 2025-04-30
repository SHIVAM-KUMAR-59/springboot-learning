package com.shivam._1.SpringBootJPA.repository;

import com.shivam._1.SpringBootJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {



}
