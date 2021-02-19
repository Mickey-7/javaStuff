package com.example.replicate.util;

import com.example.replicate.domain.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XMLToPOJO {

    @Value("${xsdFileValidator}")
    private String xsdFileValidator;

    @Value(("${directoryOnly}"))
    private String directoryOnly;

    public Employee xmlToPOJO() throws JAXBException, SAXException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(xsdFileValidator));

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(schema);

        String filename = FileWatcher.filename.toString();
        Employee employee = (Employee) unmarshaller.unmarshal(new File(directoryOnly+"/"+filename));

        return employee;




    }


}
