package com.example.replicate.util;

import com.example.replicate.domain.Employee;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class GenerateXML {

    @Value("${directoryWithFile}")
    private String directoryWithFile;

    public void generateXML() throws JAXBException, IOException {
        createXML();

        Employee employee = createEmployee();

        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        FileOutputStream fileOutputStream = new FileOutputStream(new File(directoryWithFile));

        marshaller.marshal(employee, fileOutputStream);

        fileOutputStream.close();
    }

    private Employee createEmployee() {
        Employee employee = new Employee(1, "one", 1.1);
        return employee;
    }

    private File createXML(){
        File xmlFile = new File(directoryWithFile);
        return xmlFile;
    }

}
