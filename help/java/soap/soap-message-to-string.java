// java.io.StringWriter
// javax.xml.transform.TransformerFactory
// javax.xml.transform.dom.DOMSource
// javax.xml.transform.stream.StreamResult

public static String printSoapMessage(final SOAPMessage soapMessage) {
    final StringWriter sw = new StringWriter();

    try {
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(soapMessage.getSOAPPart()), new StreamResult(sw));
    } catch (TransformerException e) {
        throw new RuntimeException(e);
    }

    return sw.toString();
}
