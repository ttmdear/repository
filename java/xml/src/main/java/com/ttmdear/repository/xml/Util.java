package com.ttmdear.repository.xml;

import org.w3c.dom.Document;
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
import java.io.StringWriter;

public class Util {

    public static String convertToString(Document document) {
        try {
            StringWriter stringWriter = new StringWriter();

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

            return stringWriter.toString();
        } catch (TransformerException e) {
            e.printStackTrace();

            return null;
        }
    }

    public static Document loadXmlFromFile(String file) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse(new File(file));

            return document;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();

            return null;
        }
    }
}
