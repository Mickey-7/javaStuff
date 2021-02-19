package com.company;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Main {

    public static final String schemaFilePath = "C:\\Users\\donat\\Downloads\\JAXBSchemaValidation\\XSDFile.xsd";
    public static final String xmlFilePath = "C:\\Users\\donat\\Downloads\\JAXBSchemaValidation\\XMLFile.xml";

    public static void main(String[] args) {
	// write your code here

        Main XMLValidator = new Main();
        boolean valid = XMLValidator.validate(xmlFilePath,schemaFilePath);
        System.out.printf("%s validation = %b.",xmlFilePath,valid);
    }

    private boolean validate(String xmlFile, String schemaFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File(schemaFile));

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
            return true;
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return false;
        }
    }
}
