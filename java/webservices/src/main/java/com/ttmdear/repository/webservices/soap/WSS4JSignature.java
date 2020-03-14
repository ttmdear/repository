package com.ttmdear.repository.webservices.soap;

import com.ttmdear.repository.webservices.Util;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.CryptoFactory;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.engine.WSSecurityEngine;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecSignature;
import org.apache.wss4j.dom.message.WSSecTimestamp;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Properties;

public class WSS4JSignature {

    static {
        org.apache.xml.security.Init.init();
    }

    public void run() throws ParserConfigurationException, SAXException, SOAPException, IOException, TransformerException, WSSecurityException {
        SOAPMessage soapMessage = Util.loadSoapMessageFromFile("/get-document.soap.xml");
        // Document soapMessageDocument = Util.resolveSoapMessageToDocument(soapMessage);

        Document soapMessageDocument = soapMessage.getSOAPPart().getEnvelope().getOwnerDocument();

        System.out.println(Util.convertDocumentToString(soapMessageDocument));

        Crypto crypto = loadCryptoConfiguration();

        WSSecHeader secHeader = new WSSecHeader(soapMessageDocument);

        secHeader.insertSecurityHeader();

        WSSecSignature sign = new WSSecSignature(secHeader);

        sign.setUserInfo("1", "test");

        // sign.setKeyIdentifierType(WSConstants.KEY_VALUE);

        // sign.setKeyIdentifierType(WSConstants.X509_KEY_IDENTIFIER);
        sign.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE);
        // sign.setKeyIdentifierType(WSConstants.ISSUER_SERIAL);
        // sign.setKeyIdentifierType(WSConstants.SKI_KEY_IDENTIFIER);
        // sign.setKeyIdentifierType(WSConstants.THUMBPRINT_IDENTIFIER);
        // sign.setKeyIdentifierType(WSConstants.ENCRYPTED_KEY_SHA1_IDENTIFIER);
        // sign.setKeyIdentifierType(WSConstants.CUSTOM_SYMM_SIGNING);

        // sign.setUseSingleCertificate(true);
        sign.setDigestAlgo(DigestMethod.SHA256);

        // Timestamp
        WSSecTimestamp timestamp = new WSSecTimestamp(secHeader);
        timestamp.setTimeToLive(60);

        timestamp.build();

        sign.build(crypto);

        // Werfikacja podpisu
        WSSecurityEngine securityEngine = new WSSecurityEngine();

        securityEngine.processSecurityHeader(soapMessageDocument, null, null, crypto);
    }

    private Crypto loadCryptoConfiguration() throws WSSecurityException {
        Properties cryptoProperties = new Properties();

        cryptoProperties.put("org.apache.ws.security.crypto.provider", "org.apache.ws.security.components.crypto.Merlin");
        cryptoProperties.put("org.apache.ws.security.crypto.merlin.file", "src/main/resources/client.jks");
        cryptoProperties.put("org.apache.ws.security.crypto.merlin.keystore.alias", "1");
        cryptoProperties.put("org.apache.ws.security.crypto.merlin.keystore.password", "testte");
        cryptoProperties.put("org.apache.ws.security.crypto.merlin.keystore.private.password", "test");

        return CryptoFactory.getInstance(cryptoProperties);
    }
}
