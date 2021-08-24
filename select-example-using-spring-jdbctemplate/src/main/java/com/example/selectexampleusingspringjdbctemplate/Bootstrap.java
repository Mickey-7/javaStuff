package com.example.selectexampleusingspringjdbctemplate;

import com.example.selectexampleusingspringjdbctemplate.domain.Student;
import com.example.selectexampleusingspringjdbctemplate.repository.StudentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class Bootstrap {
    @Autowired
    private StudentRepository studentRepository;


    @EventListener(ContextRefreshedEvent.class)
    public void onInit(){
//        System.out.println(studentRepository.selectStudentName(1));
//        System.out.println();
//        System.out.println(studentRepository.selectSingleStudent(2));
//        System.out.println("-----------------");
//        System.out.println(studentRepository.selectSingleStudent(7));
//        System.out.println("-----------------");
//        System.out.println();
//        studentRepository.selectMultipleStudents().forEach(System.out::println);

//        System.out.println(studentRepository.selectMultipleStudentsWithSameName("Souvik"));

        List<Student> studentList = studentRepository.selectMultipleStudentsWithSameName("noLocve");

        JSONObject jsonObject = new JSONObject();



        for(Student student : studentList){
            jsonObject.put("try",student);
        }

        System.out.println(jsonObject);
        if (Objects.nonNull(jsonObject)){
            System.out.println("fuck");
        }else{
            System.out.println("shit");
        }
//        System.out.println(studentRepository.selectMultipleStudentsWithSameName("noLove"));
    }
}
