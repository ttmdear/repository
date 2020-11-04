/**
 * Różne funkcje ułatwiające przetwarzanie XMLi.
 */

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Base64;

public class XMLUtil {
    public static Document convertToDocument(byte[] data) throws ParserConfigurationException, IOException,
        SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse(new ByteArrayInputStream(data));
    }

    public static String convertToString(byte[] document) throws IOException, SAXException,
        ParserConfigurationException {

        return convertToString(convertToDocument(document));
    }

    public static String convertToString(Document document) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(document);
            transformer.transform(source, result);

            return result.getWriter().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean isValidXML(String base64encoded) {
        return isValidXML(Base64.getDecoder().decode(base64encoded));
    }

    public static boolean isValidXML(byte[] data) {
        try {
            Document document = convertToDocument(data);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            return false;
        }

        return true;
    }
}
