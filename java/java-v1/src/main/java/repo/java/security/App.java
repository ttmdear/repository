package repo.java.security;

import repo.java.security.signature.Signing;

import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NoSuchAlgorithmException {
        new Signing().run();
    }
}
