package controller;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encode {

//    public static void main(String args[]) throws NoSuchAlgorithmException {
//        System.out.println(encode("admin"));
//        System.out.println( verify("admin", encode("admin") ) );
//    }

    public static String encode(String inputPassword) throws NoSuchAlgorithmException {
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(inputPassword.getBytes());
        byte[] digest = md.digest();
        String myChecksum = DatatypeConverter.printHexBinary(digest).toUpperCase();
        
        return myChecksum;
    }

    public static boolean verify(String inputPassword, String hashPassWord)
            throws NoSuchAlgorithmException {
        return encode(inputPassword).equals(hashPassWord);
    }
}
