package com.example.selectexampleusingspringjdbctemplate.repository;

import com.example.selectexampleusingspringjdbctemplate.domain.Student;
import com.example.selectexampleusingspringjdbctemplate.util.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_STUDENT_SELECT_NAME = "select student_name from student where student_id=?";
    private final String SQL_STUDENT_SELECT_SINGLE = "select * from student where student_id=?";
    private final String SQL_STUDENT_SELECT_MULTIPLE = "select * from student";

    public String selectStudentName(Integer studentId){
        return jdbcTemplate.queryForObject(SQL_STUDENT_SELECT_NAME, String.class, studentId);
    }


    public Student selectSingleStudent(Integer studentId){
        return jdbcTemplate.queryForObject(SQL_STUDENT_SELECT_SINGLE, new StudentRowMapper(), studentId);
    }

    public List<Student> selectMultipleStudents(){
        return jdbcTemplate.query(SQL_STUDENT_SELECT_MULTIPLE, new StudentRowMapper());
    }
}
