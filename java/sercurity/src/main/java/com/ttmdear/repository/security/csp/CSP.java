package com.ttmdear.repository.security.csp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CSP {

    public void run() {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
