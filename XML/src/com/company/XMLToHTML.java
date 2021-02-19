package com.company;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class XMLToHTML {
    public static void main(String[] args) throws TransformerException, IOException {
        Source xml = new StreamSource(new File("XMLFiles/productList.xml"));
        Source xslt = new StreamSource("XSLTFiles/productList.xslt");

        convertXMLToXSLT(xml, xslt);
    }

    private static void convertXMLToXSLT(Source xml, Source xslt) throws TransformerException, IOException {
        StringWriter stringWriter = new StringWriter();

        FileWriter fileWriter = new FileWriter("HTMLFiles/productList.html");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(xslt);
        transformer.transform(xml, new StreamResult(stringWriter));
        fileWriter.write(stringWriter.toString());
        fileWriter.close();

        System.out.println("html updated");
    }
}
