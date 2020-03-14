package com.ttmdear.repository.security.signature;

import sun.security.jca.Providers;

import java.security.*;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class Signing {
    public void run() throws NoSuchAlgorithmException {
        Signature signature = Signature.getInstance("SHA256withRSA");

        // signature
    }

    private void printProviders() {
        for (Provider provider: Security.getProviders()) {
            System.out.println(provider.getName());

            for (String key: provider.stringPropertyNames())
                System.out.println("\t" + key + "\t" + provider.getProperty(key));
        }
    }
}
