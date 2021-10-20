package com.ttmdear.repository.xml.dom;

import com.ttmdear.repository.xml.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.UUID;

public class CreateDocument {
    public void run() {
        try {
            // Zainicjowanie DocumentBuildera
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // Utworzenie dokumentu
            Document document = documentBuilder.newDocument();

            Element usersElement = document.createElement("users");
            usersElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:foo", "http://foo.com");

            document.appendChild(usersElement);

            usersElement.appendChild(createUserElement(document, "Jan", "Kowalski"));
            usersElement.appendChild(createUserElement(document, "Krystian", "Wrona"));
            usersElement.appendChild(createUserElement(document, "Paweł", "Kubal"));

            System.out.println(Util.convertToString(document));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private Element createUserElement(Document document, String firstName, String phone) {
        Element user = document.createElementNS("http://foo.com", "foo:user");

        user.appendChild(createElement(document, "id", UUID.randomUUID().toString()));
        user.appendChild(createElement(document, "firstName", firstName));
        user.appendChild(createElement(document, "phone", phone));

        return user;
    }

    private Element createElement(Document document, String name, String content) {
        Element element = document.createElement(name);
        element.setTextContent(content);

        return element;
    }
}
