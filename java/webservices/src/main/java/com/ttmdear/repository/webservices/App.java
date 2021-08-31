package com.ttmdear.repository.webservices;

import com.ttmdear.repository.webservices.soap.CreatingSoapMessage;
import com.ttmdear.repository.webservices.soap.LoadSoapMessageFromFile;
import com.ttmdear.repository.webservices.soap.WSS4JEncryption;
import com.ttmdear.repository.webservices.soap.WSS4JSignature;

public class App {
    public static void main(String[] args) {
        try {
            new CreatingSoapMessage().run();
            new LoadSoapMessageFromFile().run();
            new WSS4JSignature().run();
            new WSS4JEncryption().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
