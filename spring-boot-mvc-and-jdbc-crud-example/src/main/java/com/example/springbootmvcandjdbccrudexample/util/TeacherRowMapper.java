package com.example.springbootmvcandjdbccrudexample.util;

import com.example.springbootmvcandjdbccrudexample.domain.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRowMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Teacher(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("expertise")
        );
    }
}
