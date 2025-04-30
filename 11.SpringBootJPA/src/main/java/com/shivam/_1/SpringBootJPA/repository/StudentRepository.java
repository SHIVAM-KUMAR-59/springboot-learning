package com.shivam._1.SpringBootJPA.repository;

import com.shivam._1.SpringBootJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // This is a JPQL(JPA Query Language) so that when the findByName method is called this query executes
    @Query("select s from Student s where s.name=?1")
    List<Student> findByName(String name);

}
