package com.example.replicate.util;

import org.springframework.beans.factory.annotation.Value;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {



    @Value("${directoryOnly}")
    private String directoryOnly;

    @Value("${xsdFileValidator}")
    private String xsdFileValidator;

    public boolean validator() throws SAXException, IOException {
        String filename = FileWatcher.filename.toString();

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(xsdFileValidator));

        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new File(directoryOnly+"/"+filename)));

        return true;
    }
}
