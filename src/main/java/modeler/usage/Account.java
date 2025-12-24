package modeler.usage;

import manager.Chronologue;
import manager.Message;
import manager.Storage;

import java.util.List;

public class Account {

    private static String name;

    private static int level;
    private static int experience;

    private static final int EXPERIENCING = 50;

    public static void main(String[] args){
        savein("Pedro", 4, 150);
        savein("Magno", 2, 100);
        login("Pedro");
    }

    public static List<String> lookin(String givenName) {

        List<String> content = Storage.read("details.csv");

        if (content == null) {
            return null;
        }

        for (int i = 0; i < content.size(); i++) {

            List<String> data = Storage.scan(content.get(i));

            if (data.getFirst().equals(givenName)) {
                return data;
            }

        }

        return null;
    }

    public static boolean checkin(String givenName) {

        List<String> data = lookin(givenName);

        return data != null;

    }

    public static void signin(String givenName) {

        loadin(givenName, 1, 0);

    }

    public static void login(String givenName) {

        List<String> data = lookin(givenName);

        if (data == null) {
            return;
        }

        int givenLevel = 0;
        int givenExperience = 0;

        if (data != null && data.size() == 3) {
            givenLevel = Integer.parseInt(data.get(1));
            givenExperience = Integer.parseInt(data.get(2));
        } else {
            Message.fail("// Erreur : joueur introuvable -> " + givenName);
            return;
        }

        System.out.println("LOGIN DEBUG");
        System.out.println("Name: " + givenName);
        System.out.println("Level: " + givenLevel);
        System.out.println("XP: " + givenExperience);

        loadin(givenName, givenLevel, givenExperience);

    }

    public static void loadin(String givenName, int givenLevel, int givenExperience) {

        name = givenName;
        level = givenLevel;
        experience = givenExperience;

    }

    public static void savein(String givenName, int givenLevel, int givenExperience) {

        Storage.insert(givenName);
        Storage.insert(givenLevel + "");
        Storage.insert(givenExperience + "");

        Storage.stamp("details.csv");

    }

    public static String getName() {
        return name;
    }

    public static int getExperience() {
        return experience;
    }

    public static void addExperience(int amount) {

        experience += amount;

        lookExperience();

    }

    public static void lookExperience() {

        int limit = level * EXPERIENCING;

        if (experience >= limit) {

            experience -= limit;

            upLevel();
            lookExperience();

        }

    }

    public static int getLevel() {
        return level;
    }

    public static void upLevel() {
        level += 1;
    }

}



