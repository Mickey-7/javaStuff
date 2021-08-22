package com.example.selectexampleusingspringjdbctemplate;

import com.example.selectexampleusingspringjdbctemplate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {
    @Autowired
    private StudentRepository studentRepository;


    @EventListener(ContextRefreshedEvent.class)
    public void onInit(){
        System.out.println(studentRepository.selectStudentName(1));
        System.out.println();
        System.out.println(studentRepository.selectSingleStudent(2));
        System.out.println();
        studentRepository.selectMultipleStudents().forEach(System.out::println);

    }
}
