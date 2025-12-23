package modeler.game;

import java.util.LinkedList;

public class Mechanism {

    private static LinkedList<Player> players = new LinkedList<>();

    private static boolean active = false;
    private static int turn = -1;

    public static void place(Player player) {

        players.addLast(player);

    }

    public static void eject() {

        players.removeLast();

    }

    public static void purge() {

        players.clear();

    }

    public static void start() {

        if (active) {
            return;
        }

        if (players.isEmpty()) {
            return;
        }

        active = true;

        move(0);

    }

    public static void move(int focus) {

        if (players.isEmpty()) {
            return;
        }

        if (focus <= -1 || focus >= players.size()) {
            return;
        }

        Player control = getPlayer(focus);

        if (control == null) {
            return;
        }

        turn = focus;

    }

    public static void shut() {

        turn = -1;

        end();

    }

    public static void pass() {

        int next = turn + 1;

        if (next < players.size()) {
            move(next);
        } else {
            shut();
        }

    }

    public static void end() {

        if (!active) {
            return;
        }

        if (players.isEmpty()) {
            return;
        }

        active = false;

        eval();

        purge();

    }

    public static void eval() {



    }

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
