package modeler.game;

import modeler.usage.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import java.util.List;
import java.util.random.RandomGenerator;

public class Mechanism {

    private static LinkedList<Player> players = new LinkedList<>();
    private static int scale = 1;

    private static boolean active = false;
    private static int turn = -1;

    private static HashMap<String, LinkedList<Integer>> groups = new HashMap<>(3);
    private static HashMap<Integer, Integer> dices = new HashMap<>(6);

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

    public static void start() {

        players.add(new Player(Account.getName()));

        for (int i = 0; i < scale - 1; i++) {
            players.add(new Player("Player #" + i));
        }

        active = true;
        turn = 0;

        move();

    }

    public static void move() {

        groups.get("in").clear();
        groups.get("trans").clear();
        groups.get("out").clear();

        List<Integer> group = groups.get("in");

        for (int i = 0; i < 6; i++) {
            group.add(i);
        }

    }

    public static void shuffle() {

        List<Integer> group = groups.get("in");

        for (int i = 0; i < group.size(); i++) {
            dices.replace(group.get(i), RandomGenerator.getDefault().nextInt(1, 7));
        }

    }

    public static void select(String section, Integer index) {

        List<Integer> group = groups.get(section);

    }

    public static void pass() {

        int rest = groups.get("in").size();

        if (rest == 0) {

            int next = turn + 1;

            if (next >= players.size()) {
                end();
            } else {
                turn = next;
                move();
                shuffle();
            }

        } else {

            shuffle();

        }

    }

    public static void end() {

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
