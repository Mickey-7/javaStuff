package com.example.selectexampleusingspringjdbctemplate.repository;

import com.example.selectexampleusingspringjdbctemplate.domain.Student;
import com.example.selectexampleusingspringjdbctemplate.util.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_STUDENT_SELECT_NAME = "select student_name from student where student_id=?";
    private final String SQL_STUDENT_SELECT_SINGLE = "select * from student where student_id=?";
    private final String SQL_STUDENT_SELECT_SAME_NAME = "select * from student where student_name=?";
    private final String SQL_STUDENT_SELECT_MULTIPLE = "select * from student";

    public String selectStudentName(Integer studentId){
        return jdbcTemplate.queryForObject(SQL_STUDENT_SELECT_NAME, String.class, studentId);
    }

    public Student selectSingleStudent(Integer studentId){
        return jdbcTemplate.query(SQL_STUDENT_SELECT_SINGLE, resultSet -> {
            if (resultSet.next()){
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setStudentDob(resultSet.getString("student_dob"));
                student.setStudentEmail(resultSet.getString("student_email"));
                student.setStudentAddress(resultSet.getString("student_address"));
                return student;
            }else{
                return null;
            }
        }, studentId);
    }

    public List<Student> selectMultipleStudentsWithSameName(String studentName){
        return jdbcTemplate.query(SQL_STUDENT_SELECT_SAME_NAME, new StudentRowMapper(), studentName);
    }

    public List<Student> selectMultipleStudents(){
        return jdbcTemplate.query(SQL_STUDENT_SELECT_MULTIPLE, new StudentRowMapper());
    }
}
