package repo.java.security;

import com.ttmdear.repository.security.signature.Signing;

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
