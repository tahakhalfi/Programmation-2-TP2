package manager;

public class Message {

    public static final String DEFAULT = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void print(String message, String color) {
        System.out.println(color + message + DEFAULT);
    }

    public static void state(String message) {
        print(message, DEFAULT);
    }

    public static void inform(String message) {
        print(message, BLUE);
    }

    public static void warn(String message) {
        print(message, YELLOW);
    }

    public static void pass(String message) {
        print(message, GREEN);
    }

    public static void fail(String message) {
        print(message, RED);
    }

}
