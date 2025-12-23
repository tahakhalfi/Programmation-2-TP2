package modeler.game;

import java.util.LinkedList;

public class Mechanism {

    private static LinkedList<Player> players = new LinkedList<>();

    public static void sign(Player player) {
        players.add(player);
    }

    public static void start() {

        if (players.isEmpty()) {
            return;
        }

    }

    public static void move() {

    }

    public static void alert(Player player) {

    }

    public static void end() {

    }

}
