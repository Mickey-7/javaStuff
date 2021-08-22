package com.example.springbootmvcandjdbccrudexample.controller;

import com.example.springbootmvcandjdbccrudexample.domain.Teacher;
import com.example.springbootmvcandjdbccrudexample.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/{id}")
    public String getTeacher(@PathVariable int id, ModelMap teacherModel){
        Teacher teacher = teacherService.getTeacher(id);
        teacherModel.addAttribute("teacher",teacher);
        //corresponds to teacher.jsp
        return "teacher";
    }

    @GetMapping("/teachers")
    public String getTeachers(ModelMap teacherModel){
        List<Teacher> teachers = teacherService.getTeachers();
        teacherModel.addAttribute("teachers",teachers);
        //corresponds to teachers.jsp
        return "teachers";
    }

    @GetMapping("/addTeacher")
    public String addPage(){
        return "add";
    }


    @PostMapping("/add/teacher")
    public String addTeacher(@RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "expertise", required = true) String expertise, ModelMap teacherModel) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setExpertise(expertise);
        teacherService.addTeacher(teacher);
        teacherModel.addAttribute("msg", "Teacher added successfully");
        List<Teacher> teachers = teacherService.getTeachers();
        teacherModel.addAttribute("teachers", teachers);
        return "redirect:/teachers";
    }

    @GetMapping("/delete/teacher/{id}")
    public String deleteTeacher(@PathVariable int id, ModelMap teacherModel){
        teacherService.deleteTeacher(id);
        List<Teacher> teachers = teacherService.getTeachers();
        teacherModel.addAttribute("teachers",teachers);
        teacherModel.addAttribute("msg","Teacher deleted successfully");
        return "redirect:/teachers";
    }

    @GetMapping("/update/teacher/{id}")
    public String updatePage(@PathVariable("id") int id, ModelMap teacherModel){
        teacherModel.addAttribute("id",id);
        Teacher teacher = teacherService.getTeacher(id);
        teacherModel.addAttribute("teacher",teacher);
        return "update";
    }

    @PostMapping("/update/teacher")
    public String updateTeacher(@RequestParam int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "expertise", required = true) String expertise, ModelMap teacherModel){
        Teacher teacher = new Teacher(id, name, expertise);
        teacherService.updateTeacher(teacher);
        List<Teacher> teachers = teacherService.getTeachers();
        teacherModel.addAttribute("teachers", teachers);
        teacherModel.addAttribute("id", id);
        teacherModel.addAttribute("msg", "Teacher updated successfully");
        return "redirect:/teachers";
    }


}
