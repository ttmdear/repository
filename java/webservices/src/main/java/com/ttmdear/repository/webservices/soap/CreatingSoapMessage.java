package com.ttmdear.repository.webservices.soap;

import com.ttmdear.repository.webservices.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import java.util.HashMap;
import java.util.Map;

public class CreatingSoapMessage {
    private static final String FOO_NS = "http://foo.com";
    private static final String SECURITY_NS = "http://security.com";
    private static final String SECURITY_DIGEST_NS = "http://security.digets.com";
    private static final String XMLNS_NS = "http://www.w3.org/2000/xmlns/";
    private static final String SOAP_NS = "http://schemas.xmlsoap.org/soap/envelope/";

    public void run() throws SOAPException, TransformerException, ParserConfigurationException {
        // Tworzymy obiekt odpowiedzialny za tworzenie elementów SOAPa
        SOAPFactory soapFactory = SOAPFactory.newInstance();

        // Tworzymy wiadomość
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();

        // Pobieramy referencje do elementów SOAPa
        SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
        SOAPHeader soapHeader = soapMessage.getSOAPHeader();
        SOAPBody soapBody = soapMessage.getSOAPBody();

        soapEnvelope.setAttributeNS(XMLNS_NS, "xmlns:foo", FOO_NS);
        soapEnvelope.setAttributeNS(XMLNS_NS, "xmlns:ds", SECURITY_DIGEST_NS);
        soapEnvelope.setAttributeNS(XMLNS_NS, "xmlns:sec", SECURITY_NS);
        soapEnvelope.setAttributeNS(XMLNS_NS, "xmlns:soap", SOAP_NS);

        // Definiowanie nagłówka
        SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(new QName(SECURITY_NS, "Security", "sec"));

        SOAPElement signature  = soapHeaderElement.addChildElement(new QName(SECURITY_DIGEST_NS, "Signature", "ds"));
        signature.setTextContent("fa5e6434-757d-4ddc-b6e8-d2bcbab7d2ca");

        // Dodanie body
        SOAPBodyElement getUserElement = soapBody.addBodyElement(new QName(FOO_NS, "getUser", "foo"));

        // Utworzenie elementu za pomocą QName. W takiej sytuacji podanie przestrzeni jest wymagane.
        getUserElement.addChildElement(new QName(FOO_NS, "arg-a", "foo")).setTextContent("1");

        // Utworzenie elementu za pomocą metody addChildElement, podaje nazwę i prefix.
        getUserElement.addChildElement("arg-b", "foo").setTextContent("2");

        // Utworzenie elementu za pomocą metody addChildElement, podaje nazwę i prefix i przestrzeń
        getUserElement.addChildElement("arg-b", "foo-t", FOO_NS).setTextContent("3");

        System.out.println(Util.convertSoapMessageToString(soapMessage));
    }

    private Document createDocument() throws ParserConfigurationException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        Map<String, Element> elements = new HashMap<>();

        elements.put("getUsers", document.createElement("getUsers"));
        elements.put("arg1", document.createElement("arg"));
        elements.put("arg2", document.createElement("arg"));

        elements.get("arg1").setTextContent("10");
        elements.get("arg2").setTextContent("20");

        elements.get("getUsers").appendChild(elements.get("arg1"));
        elements.get("getUsers").appendChild(elements.get("arg2"));

        document.appendChild(elements.get("getUsers"));

        return document;
    }
}
