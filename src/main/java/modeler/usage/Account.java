package modeler.usage;

import manager.Chronologue;
import manager.Storage;

import java.util.List;

public class Account {

    private static String name;

    private static int level;
    private static int experience;

    private static final int EXPERIENCING = 50;

    public static void signin(String givenName) {

        statein(
                givenName,
                1,
                0
        );

    }

    // modification

    public static void login(String givenName) {

        List<String> player = getPlayerByName(givenName);

        int givenLevel = 0;
        int givenExperience = 0;

        if (player != null && player.size() == 3) {
            givenLevel = Integer.parseInt(player.get(1));
            givenExperience = Integer.parseInt(player.get(2));
        } else {
            System.out.println("Erreur : joueur introuvable -> " + givenName);
            return;
        }

        System.out.println("LOGIN DEBUG");
        System.out.println("Name: " + givenName);
        System.out.println("Level: " + givenLevel);
        System.out.println("XP: " + givenExperience);

        statein(
                givenName,
                givenLevel,
                givenExperience
        );
    }

    // modification

    public static List<String> getPlayerByName(String givenName) {

        List<String> content = Storage.read("details.csv");
        if (content == null) return null;

        for (int i = 0; i < content.size(); i++) {
            List<String> data = Storage.scan(content.get(i));

            if (data.get(0).equals(givenName)) {
                return data; // [name, level, xp]
            }
        }
        return null;
    }

    // modification

    public static void main(String[] args){
        savein("Pedro", 4, 150);
        savein("Magno", 2, 100);
        login("Pedro");
    }

    public static void statein(String givenName, int givenLevel, int givenExperience) {

        name = givenName;
        level = givenLevel;
        experience = givenExperience;

    }

    // modification

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



