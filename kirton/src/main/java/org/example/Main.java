package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
public class Main {
    private static final String CHARACTERS = "ABCDEFGHJKMNOPQRSTUVWXYZabcdefghjkmnopqrstuvwxyz0123456789";
    private static final int PASSWORD_LENGTH = 8; // длина пароля
    private static final int NUMBER_OF_PASSWORDS = 1000; // количество паролей
    private static final SecureRandom RANDOM = new SecureRandom();
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passwords.txt"))) {
            for (int i = 0; i < NUMBER_OF_PASSWORDS; i++) {
                String password = generateRandomPassword(PASSWORD_LENGTH);
                writer.write(password);
                writer.newLine();
            }
            System.out.println("Пароли успешно записаны в файл passwords.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        return password.toString();
    }
}