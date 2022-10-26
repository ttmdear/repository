package repo.java.xml.transform;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TransformStreamToStream {

    public void run() throws TransformerException, ParserConfigurationException, IOException,
            SAXException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(new File("users.xml"));

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");

        FileOutputStream fileOutputStream = new FileOutputStream("users-i.xml");

        transformer.transform(new DOMSource(document), new StreamResult(fileOutputStream));
    }
}
