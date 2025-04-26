package com.shivam._6.SpringBootJDBC.repository;

import com.shivam._6.SpringBootJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student){
        String sql = "INSERT INTO STUDENT (ROLL,NAME,MARKS) VALUES (?, ?, ?)";
        int rows = jdbc.update(sql, student.getRoll(), student.getName(), student.getMarks());
        System.out.println("Student Saved Successfully, rows affected: " + rows);
    }

    public List<Student> findAll(){
        System.out.println("Getting..");

        String sql = "SELECT * FROM STUDENT";

        // Using lamba expressions
        RowMapper<Student> mapper = ( rs,  rowNum) -> {

                Student s = new Student();
                s.setRoll(rs.getInt("roll"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));

                return s;
        };

        return jdbc.query(sql, mapper);
    }
}
