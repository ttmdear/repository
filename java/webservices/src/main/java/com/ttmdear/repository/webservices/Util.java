package com.ttmdear.repository.webservices;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

public class Util {

    public static String convertSoapMessageToString(SOAPMessage soapMessage) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        StringWriter stringWriter = new StringWriter();

        transformer.transform(new DOMSource(soapMessage.getSOAPPart()), new StreamResult(stringWriter));

        return stringWriter.toString();
    }

    public static String convertDocumentToString(Document document) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        StringWriter stringWriter = new StringWriter();

        transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

        return stringWriter.toString();
    }

    public static Document resolveSoapMessageToDocument(SOAPMessage soapMessage) throws TransformerException, ParserConfigurationException, SOAPException {
        Source src = soapMessage.getSOAPPart().getContent();

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        DOMResult result = new DOMResult();

        transformer.transform(src, result);

        return (Document)result.getNode();
    }

    public static SOAPMessage loadSoapMessageFromFile(String file) throws ParserConfigurationException, IOException, SAXException, SOAPException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Util.class.getResourceAsStream(file));

        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();

        soapMessage.getSOAPPart().setContent(new DOMSource(document));

        return soapMessage;
    }
}
