package repo.java.xml;

import org.xml.sax.SAXException;
import repo.java.xml.dom.CreateDocument;
import repo.java.xml.transform.TransformStreamToStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        new CreateDocument().run();
        new TransformStreamToStream().run();
    }
}
