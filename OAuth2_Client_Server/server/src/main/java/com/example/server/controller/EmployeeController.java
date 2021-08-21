package com.example.server.controller;

import com.example.server.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Controller
public class EmployeeController {
    @RequestMapping(value = "/user/getEmployeesList")
    @ResponseBody
    public List<Employee> getEmployeesList(){
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmpId("1");
        employee.setEmpName("name");
        employees.add(employee);
        return employees;
    }
}
