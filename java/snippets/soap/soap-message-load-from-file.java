/**
 * Wczytanie wiadomość SOAP z pliku.
 */
package com.ttmdear.repository.webservices.soap;

import com.ttmdear.repository.webservices.Util;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import java.io.FileInputStream;
import java.io.IOException;

public class CreatingSoapMessageFromFile {

    public void run() throws SOAPException, TransformerException, ParserConfigurationException, IOException, SAXException {

        // Tworzymy wiadomość
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();

        Document soapMessageDocument = loadDocument("/get-document.soap.xml");

        soapMessage.getSOAPPart().setContent(new DOMSource(soapMessageDocument));

        System.out.println(Util.convertSoapMessageToString(soapMessage));
    }

    private Document loadDocument(String resource) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        return documentBuilder.parse(this.getClass().getResourceAsStream(resource));
    }
}
