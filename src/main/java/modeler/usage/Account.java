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

    public static void enterin(String givenName) {

        if (checkin(givenName)) {
            login(givenName);
        } else {
            signin(givenName);
        }

    }

    public static void signin(String givenName) {

        List<String> data = lookin(givenName);

        if (data != null) {
            return;
        }

        int givenLevel = 1;
        int givenExperience = 0;

        Storage.release();

        Storage.insert(givenName);
        Storage.insert(String.valueOf(givenLevel));
        Storage.insert(String.valueOf(givenExperience));

        Storage.stamp("details.csv", null);

        loadin(givenName, givenLevel, givenExperience);

    }

    public static void login(String givenName) {

        List<String> data = lookin(givenName);

        if (data == null) {
            return;
        }

        int givenLevel = Integer.parseInt(data.get(1));
        int givenExperience = Integer.parseInt(data.get(2));

        loadin(givenName, givenLevel, givenExperience);

    }

    public static void loadin(String givenName, int givenLevel, int givenExperience) {

        name = givenName;
        level = givenLevel;
        experience = givenExperience;

    }

    public static void savein() {

        Storage.release();

        Storage.insert(name);
        Storage.insert(String.valueOf(level));
        Storage.insert(String.valueOf(experience));

        List<String> content = Storage.read("details.csv");

        if (content == null) {
            return;
        }

        for (int index = 0; index < content.size(); index++) {

            List<String> data = Storage.scan(content.get(index));

            if (!data.getFirst().equals(name)) {
                continue;
            }

            Storage.stamp("details.csv", index);

            break;

        }

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



