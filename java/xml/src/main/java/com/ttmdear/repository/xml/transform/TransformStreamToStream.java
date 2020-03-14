package com.ttmdear.repository.xml.transform;

import com.ttmdear.repository.xml.Util;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class TransformStreamToStream {

    public void run() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new File("users.xml"));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");

            FileOutputStream fileOutputStream = new FileOutputStream("users-i.xml");

            transformer.transform(new DOMSource(document), new StreamResult(fileOutputStream));
        } catch (TransformerException | ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
