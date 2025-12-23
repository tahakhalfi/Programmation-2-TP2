package modeler.game;

import java.util.LinkedList;

public class Mechanism {

    private static boolean active = false;
    private static int turn = -1;

    private static LinkedList<Player> players = new LinkedList<>();

    public static void sign(Player player) {
        players.add(player);
    }

    public static void start() {

        if (active) {
            return;
        }

        if (players.isEmpty()) {
            return;
        }

        active = true;

    }

    public static void move() {

    }

    public static void alert() {

    }

    public static void end() {

        if (!active) {
            return;
        }

        if (players.isEmpty()) {
            return;
        }

        active = false;

    }

}
