package modeler.game;

import java.util.LinkedList;

public class Mechanism {

    private static LinkedList<Player> players = new LinkedList<>();
    private static int scale = 1;

    private static boolean active = false;
    private static int turn = -1;

    public static int insert() {
        if (scale < 6) {
            scale += 1;
        }
        return scale;
    }

    public static int extract() {
        if (scale > 1) {
            scale -= 1;
        }
        return scale;
    }

    public static int normalize() {
        scale = 1;
        return scale;
    }

    public static void start() {}

    public static void move() {}

    public static void shut() {}

    public static void pass() {}

    public static void end() {}

    public static boolean getActive() {
        return active;
    }

    public static int getTurn() {
        return turn;
    }

    public static LinkedList<Player> getPlayers() {
        return players;
    }

    public static Player getPlayer(int index) {
        return players.get(index);
    }

    public static Player getControl() {
        return getPlayer(turn);
    }

}
