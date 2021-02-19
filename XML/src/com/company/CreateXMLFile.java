package com.company;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXMLFile {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("company");
        doc.appendChild(rootElement);

        Element staff = doc.createElement("Staff");
        rootElement.appendChild(staff);

        Attr attr = doc.createAttribute("id");
        attr.setValue("1");
        staff.setAttributeNode(attr);

        Element firstname = doc.createElement("firstname");
        firstname.appendChild(doc.createTextNode("yong"));
        staff.appendChild(firstname);

        Element lastname = doc.createElement("lastname");
        lastname.appendChild(doc.createTextNode("mook kim"));
        staff.appendChild(lastname);

        Element nickname = doc.createElement("nickname");
        nickname.appendChild(doc.createTextNode("mkyong"));
        staff.appendChild(nickname);

        Element salary = doc.createElement("salary");
        salary.appendChild(doc.createTextNode("12542"));
        staff.appendChild(salary);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("XMLFiles/newlyCreatedFile.xml"));
        transformer.transform(domSource, result);




        System.out.println("File created!");



    }
}
