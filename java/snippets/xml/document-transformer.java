/**
 * Wczytanie dokumentu z pliku przez transformacje
 */
public Document loadDocumentByTransformer(String resource) throws ParserConfigurationException, IOException, SAXException, TransformerException {
    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

    Transformer transformer = TransformerFactory.newInstance().newTransformer();

    transformer.transform(new StreamSource(this.getClass().getResourceAsStream("/get-document.soap.xml")), new DOMResult(document));

    return document;
}
