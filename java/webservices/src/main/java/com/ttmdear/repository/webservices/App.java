package com.ttmdear.repository.webservices;

import com.ttmdear.repository.webservices.soap.WSS4JEncryption;
import com.ttmdear.repository.webservices.soap.WSS4JSignature;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        try {
            // (new CreatingSoapMessage()).run();
            // (new LoadSoapMessageFromFile()).run();
            // (new WSS4JSignature()).run();
            (new WSS4JEncryption()).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
