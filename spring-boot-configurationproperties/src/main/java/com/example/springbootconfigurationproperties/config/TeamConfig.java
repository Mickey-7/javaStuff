package com.example.springbootconfigurationproperties.config;

import com.example.springbootconfigurationproperties.model.Company;
import com.example.springbootconfigurationproperties.model.Employee;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "app")
@PropertySource("classpath:myteam.properties")
public class TeamConfig {
    private Company company;
    private List<Employee> employees;
    private Map<String, String> technologies;
    private String[] clients;

    public TeamConfig() {
    }

    public TeamConfig(Company company, List<Employee> employees, Map<String, String> technologies, String[] clients) {
        this.company = company;
        this.employees = employees;
        this.technologies = technologies;
        this.clients = clients;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Map<String, String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Map<String, String> technologies) {
        this.technologies = technologies;
    }

    public String[] getClients() {
        return clients;
    }

    public void setClients(String[] clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "TeamConfig{" +
                ", company=" + company +
                ", employees=" + employees +
                ", technologies=" + technologies +
                ", clients=" + Arrays.toString(clients) +
                '}';
    }
}
