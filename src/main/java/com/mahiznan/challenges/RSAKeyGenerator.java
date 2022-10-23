package com.mahiznan.challenges;

import java.security.*;

public class RSAKeyGenerator {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();
        System.out.println(privKey.toString());
    }
}
