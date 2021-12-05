package CicekSepeti.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class RandomUser {

    public static String getRandomPassword(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder ap = new StringBuilder();
        Random random = new Random();
        while (0 < length--) {
            ap.append(chars.charAt(random.nextInt(chars.length())));
        }
        return ap.toString();
    }

    public static String getRandomName() throws FileNotFoundException {
        Scanner names = new Scanner(new File(System.getProperty("user.dir") + "/bin/names.txt"));
        StringBuilder n = new StringBuilder();
        Random random = new Random();

        while (names.hasNext()) {
            n.append(names.nextLine());
        }
        String[] nameArray = n.toString().split(",");

        return nameArray[random.nextInt(nameArray.length)];
    }

    public static String getRandomSurname() throws FileNotFoundException {
        Scanner surnames = new Scanner(new File(System.getProperty("user.dir") + "/bin/surnames.txt"));
        StringBuilder n = new StringBuilder();
        Random random = new Random();

        while (surnames.hasNext()) {
            n.append(surnames.nextLine());
        }
        String[] surnameArray = n.toString().split(",");

        return surnameArray[random.nextInt(surnameArray.length)];
    }

    public static String getRandomEmail(String name, String surname) {
        Random random = new Random();
        int randomYear = 1990 + random.nextInt(10);
        return name + surname + randomYear + "@homework.com";
    }

    public static String[] getRandomUser() throws FileNotFoundException {
        String name = getRandomName();
        String surname = getRandomSurname();
        String email = getRandomEmail(name, surname);
        String password = getRandomPassword(15);

        return new String[]{name, surname, email, password};
    }
}
