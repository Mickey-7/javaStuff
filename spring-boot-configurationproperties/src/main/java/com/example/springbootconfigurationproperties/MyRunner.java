package com.example.springbootconfigurationproperties;

import com.example.springbootconfigurationproperties.config.TeamConfig;
import com.example.springbootconfigurationproperties.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private TeamConfig teamConfig;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner");

        System.out.println("---Object---");
        String companyName = teamConfig.getCompany().getName();
        System.out.println(companyName);
        String companyCeo = teamConfig.getCompany().getCeo();
        System.out.println(companyCeo);
        String companyLocation = teamConfig.getCompany().getLocation();
        System.out.println(companyLocation);


        System.out.println("---List---");
        List<Employee> employees = teamConfig.getEmployees();
        System.out.println(employees);

        System.out.println("---Map---");
        Map<String,String> technologies = teamConfig.getTechnologies();
        System.out.println(technologies);

        System.out.println("---Array---");
        String[] clients = teamConfig.getClients();
        System.out.println(Arrays.toString(clients));
    }
}
