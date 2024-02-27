package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        System.out.print("Enter desired password: ");
        String password = c.nextLine();
        char[] salt = Main.generateSalt();
        char[] hashedPassword = Main.hashPassword(password.toCharArray(), salt);
        System.out.println("Generated salt: " + new String(salt));
        System.out.println("Hashed password: " + new String(hashedPassword));

        c.close();
    }

    private static char[] hashPassword(char[] password, char[] salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            for (char c : password) {
                digest.update((byte) c);
            }
            for (char c : salt) {
                digest.update((byte) c);
            }
            byte[] hash = digest.digest();
            return Base64.getEncoder().encodeToString(hash).toCharArray();
        } catch (NoSuchAlgorithmException ignored) {
        }
        return new char[] { ' ' };
    }

    private static char[] generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] id = new byte[32];
        sr.nextBytes(id);
        return Base64.getEncoder().encodeToString(id).toCharArray();
    }
}
