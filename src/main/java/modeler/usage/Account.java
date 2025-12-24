package modeler.usage;

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

    public static void login(String givenName) {

        int givenLevel = 1;
        int givenExperience = 0;

        statein(
                givenName,
                givenLevel,
                givenExperience
        );

    }

    public static void statein(String givenName, int givenLevel, int givenExperience) {

        name = givenName;
        level = givenLevel;
        experience = givenExperience;

    }

    public static void savein() {

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

