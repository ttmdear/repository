package com.ttmdear.repository.webservices.soap;

import com.ttmdear.repository.webservices.Util;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.CryptoFactory;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.common.util.KeyUtils;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.engine.WSSecurityEngine;
import org.apache.wss4j.dom.message.WSSecEncrypt;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecSignature;
import org.apache.wss4j.dom.message.WSSecTimestamp;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Properties;

public class WSS4JEncryption {

    static {
        org.apache.xml.security.Init.init();
    }

    public void run() throws ParserConfigurationException, SAXException, SOAPException, IOException, TransformerException, WSSecurityException {
        SOAPMessage soapMessage = Util.loadSoapMessageFromFile("/get-document.soap.xml");

        Document soapMessageDocument = soapMessage.getSOAPPart().getEnvelope().getOwnerDocument();

        System.out.println(Util.convertDocumentToString(soapMessageDocument));

        Crypto crypto = loadCryptoConfiguration();

        WSSecHeader secHeader = new WSSecHeader(soapMessageDocument);
        secHeader.insertSecurityHeader();

        WSSecEncrypt builder = new WSSecEncrypt(secHeader);

        builder.setUserInfo("1", "test");
        builder.setKeyIdentifierType(WSConstants.X509_KEY_IDENTIFIER);

        // builder.setSymmetricEncAlgorithm(WSConstants.TRIPLE_DES);
        builder.setSymmetricEncAlgorithm(WSConstants.AES_256_GCM);

        // KeyGenerator keyGen = KeyUtils.getKeyGenerator(WSConstants.TRIPLE_DES);

        // Klucz można wygenerować recznie, inaczej zostanie automatycznie wygenerowany
        // KeyGenerator keyGen = KeyUtils.getKeyGenerator(WSConstants.AES_256_GCM);
        // builder.setEphemeralKey(keyGen.generateKey().getEncoded());

        Document encryptedDoc = builder.build(crypto);

        System.out.println(Util.convertDocumentToString(soapMessageDocument));
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
