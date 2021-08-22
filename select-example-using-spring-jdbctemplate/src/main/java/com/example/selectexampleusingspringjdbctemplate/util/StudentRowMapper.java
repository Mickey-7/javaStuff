package com.example.selectexampleusingspringjdbctemplate.util;

import com.example.selectexampleusingspringjdbctemplate.domain.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper  implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setStudentId(resultSet.getInt("student_id"));
        student.setStudentName(resultSet.getString("student_name"));
        student.setStudentDob(resultSet.getString("student_dob"));
        student.setStudentEmail(resultSet.getString("student_email"));
        student.setStudentAddress(resultSet.getString("student_address"));
        return student;
    }
}
