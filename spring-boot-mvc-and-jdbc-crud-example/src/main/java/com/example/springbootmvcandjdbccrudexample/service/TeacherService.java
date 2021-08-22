package com.example.springbootmvcandjdbccrudexample.service;

import com.example.springbootmvcandjdbccrudexample.domain.Teacher;
import com.example.springbootmvcandjdbccrudexample.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getTeacher(final int id){
        return teacherRepository.getTeacher(id);
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.getTeachers();
    }

    public void addTeacher(final Teacher teacher){
        teacherRepository.addTeacher(teacher);
    }

    public void updateTeacher(final Teacher teacher){
        teacherRepository.updateTeacher(teacher);
    }

    public void deleteTeacher(final int id){
        teacherRepository.deleteTeacher(id);
    }

}
