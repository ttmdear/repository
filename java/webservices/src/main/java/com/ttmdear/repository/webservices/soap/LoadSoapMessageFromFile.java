package com.ttmdear.repository.webservices.soap;

import com.ttmdear.repository.webservices.Util;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class LoadSoapMessageFromFile {

    public void run() throws SOAPException, TransformerException, ParserConfigurationException, IOException, SAXException {
        loadByDOM();
        loadByTransformer();
    }

    private void loadByTransformer() throws ParserConfigurationException, TransformerException, SOAPException, IOException, SAXException {
        // Tworzymy wiadomość
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();

        Document soapMessageDocument = loadDocumentByTransformer("/get-document.soap.xml");

        soapMessage.getSOAPPart().setContent(new DOMSource(soapMessageDocument));

        System.out.println(Util.convertSoapMessageToString(soapMessage));
    }

    private void loadByDOM() throws SOAPException, IOException, SAXException, ParserConfigurationException, TransformerException {
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

    private Document loadDocumentByTransformer(String resource) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.transform(new StreamSource(this.getClass().getResourceAsStream("/get-document.soap.xml")), new DOMResult(document));

        return document;
    }
}
