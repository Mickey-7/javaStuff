package com.company;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

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
import java.io.IOException;

public class ModifyXMLFile {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String filePath = "XMLFiles/file.xml";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filePath);

        Node company = doc.getFirstChild();
        Node staff = doc.getElementsByTagName("staff").item(0);
        NamedNodeMap attr = staff.getAttributes();
        Node nodeAttr = attr.getNamedItem("id");
        nodeAttr.setTextContent("2");

        Element age = doc.createElement("age");
        age.appendChild(doc.createTextNode("28"));
        staff.appendChild(age);

        NodeList nodeList = staff.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if ("salary".equals(node.getNodeName())){
                node.setTextContent("22542351");
            }
            if ("firstname".equals(node.getNodeName())){
                staff.removeChild(node);
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(domSource, result);

        System.out.println("Done");

    }
}
