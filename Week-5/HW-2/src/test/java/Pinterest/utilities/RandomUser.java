package Pinterest.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class RandomUser {
    Random random = new Random();

    public String getRandomPassword(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder ap = new StringBuilder();
        while (0 < length--) {
            ap.append(chars.charAt(random.nextInt(chars.length())));
        }
        return ap.toString();
    }

    public String getRandomName() throws FileNotFoundException {
        Scanner names = new Scanner(new File(System.getProperty("user.dir") + "/bin/names.txt"));
        StringBuilder n = new StringBuilder();

        while (names.hasNext()) {
            n.append(names.nextLine());
        }
        String[] nameArray = n.toString().split(",");

        return nameArray[random.nextInt(nameArray.length)];
    }

    public String getRandomSurname() throws FileNotFoundException {
        Scanner surnames = new Scanner(new File(System.getProperty("user.dir") + "/bin/surnames.txt"));
        StringBuilder n = new StringBuilder();

        while (surnames.hasNext()) {
            n.append(surnames.nextLine());
        }
        String[] surnameArray = n.toString().split(",");

        return surnameArray[random.nextInt(surnameArray.length)];
    }

    public String getRandomEmail(String name, String surname) {
        return name + surname + getRandomYear() + "@gmail.com";
    }

    public String getRandomYear() {
        int randomYear = 1990 + random.nextInt(10);
        return Integer.toString(randomYear);
    }

    public String getRandomAge() {
        int randomAge = 18 + random.nextInt(10);
        return Integer.toString(randomAge);
    }

    public String getRandomTopics() throws FileNotFoundException {
        Scanner topics = new Scanner(new File(System.getProperty("user.dir") + "/bin/topics.txt"));
        StringBuilder n = new StringBuilder();

        while (topics.hasNext()) {
            n.append(topics.nextLine());
        }
        String[] topicsArray = n.toString().split(",");

        return topicsArray[random.nextInt(topicsArray.length)];
    }

    public String getRandomCountry() throws FileNotFoundException {
        Scanner country = new Scanner(new File(System.getProperty("user.dir") + "/bin/country.txt"));
        StringBuilder n = new StringBuilder();

        while (country.hasNext()) {
            n.append(country.nextLine());
        }
        String[] countryArray = n.toString().split(",");

        return countryArray[random.nextInt(countryArray.length)];
    }

    public String getRandomGender() {
        int randomGender = random.nextInt(2);
        String gender;
        switch (randomGender) {
            case 0:
                gender = "Female";
                break;
            case 1:
                gender = "Male";
                break;
            default:
                gender = "";
        }
        return gender;
    }

    public String[] getRandomUser() throws FileNotFoundException {
        String name = getRandomName();
        String surname = getRandomSurname();
        String email = getRandomEmail(name, surname);
        String password = getRandomPassword(15);

        return new String[]{name, surname, email, password};
    }
}