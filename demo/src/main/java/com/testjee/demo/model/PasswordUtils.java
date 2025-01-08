package com.testjee.demo.model;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    // Méthode pour hasher un mot de passe
    public static String hashPassword(String plainPassword, @SuppressWarnings("exports") BCrypt BCrypt) {
            return org.mindrot.jbcrypt.BCrypt.hashpw(plainPassword, org.mindrot.jbcrypt.BCrypt.gensalt());
    }

    // Méthode pour vérifier si le mot de passe correspond au hash
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}