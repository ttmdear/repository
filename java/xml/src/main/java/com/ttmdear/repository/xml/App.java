package com.ttmdear.repository.xml;

import com.ttmdear.repository.xml.dom.CreateDocument;
import com.ttmdear.repository.xml.transform.TransformStreamToStream;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        new CreateDocument().run();
        new TransformStreamToStream().run();
    }
}
