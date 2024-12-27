package com.example.demo.Config;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class PasswordEncryptor {

//	private static final String SECRET_KEY = "YourSecretKey"; // Replace with your secret key

//	public static String encrypt(String password) {
//		try {
//			SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
//			byte[] encryptedBytes = cipher.doFinal(password.getBytes());
//			return Base64.getEncoder().encodeToString(encryptedBytes);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}


    private static final String SECRET_KEY = "$10$hgYEBxC/aQDOlBjRL89DVevhzrKlftmLMtyRIU2TsFX6EWGjspjEq"; // Replace with your secret key
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256; // Use 128 or 256 for AES key length

    public static String encrypt(String password) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SECRET_KEY.getBytes(), ITERATIONS, KEY_LENGTH);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//	public static String decrypt(String encryptedPassword) {
//		try {
//			SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//			byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
//			byte[] decryptedBytes = cipher.doFinal(decodedBytes);
//			return new String(decryptedBytes);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
    
    public static String decrypt(String encryptedPassword) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SECRET_KEY.getBytes(), ITERATIONS, KEY_LENGTH);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


	public static void main(String[] args) {
		String password = "$10$hgYEBxC/aQDOlBjRL89DVevhzrKlftmLMtyRIU2TsFX6EWGjspjEq";
		String encryptedPassword = encrypt(password);
//		String password = "$10$hgYEBxC/aQDOlBjRL89DVevhzrKlftmLMtyRIU2TsFX6EWGjspjEq";
//		String encryptedPassword = decrypt(password);
		System.out.println(encryptedPassword + " encryptedPassword");
		String decryptedPassword = decrypt(encryptedPassword);

		System.out.println(decryptedPassword + " decryptedPassword");

	}
}
