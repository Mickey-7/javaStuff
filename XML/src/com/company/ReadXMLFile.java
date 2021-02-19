package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXMLFile {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File xmlFile = new File("XMLFiles/staff.xml");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element: "+doc.getDocumentElement().getNodeName());

        NodeList nodeList = doc.getElementsByTagName("staff");
        System.out.println("---------------------------");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("\nCurrent element: "+node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                System.out.println("Staff id: "+element.getAttribute("id"));
                System.out.println("Firstname: "+element.getAttribute("firstname"));
                System.out.println("Lastname: "+element.getAttribute("lastname"));
                System.out.println("Nickname: "+element.getAttribute("nickname"));
                System.out.println("Salary: "+element.getAttribute("salary"));

            }
        }

    }
}
