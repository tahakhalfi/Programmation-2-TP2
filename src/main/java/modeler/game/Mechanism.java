package modeler.game;

import modeler.usage.Account;

import java.util.*;

import java.util.random.RandomGenerator;

public class Mechanism {

    private static LinkedList<Player> players = new LinkedList<>();
    private static int scale = 1;

    private static final int MIN_PLAYERS = 1;
    private static final int MAX_PLAYERS = 6;

    private static boolean active = false;
    private static int turn = -1;

    private static HashMap<Integer, String> sections = new HashMap<>(6);
    private static HashMap<Integer, Integer> values = new HashMap<>(6);

    private static final int QUANTITY = 6;

    public static int insert() {
        if (scale < MAX_PLAYERS) {
            scale += 1;
        }
        return scale;
    }

    public static int extract() {
        if (scale > MIN_PLAYERS) {
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

        for (int index = 0; index < QUANTITY; index++) {
            values.put(index, index + 1);
        }

        move();

    }

    public static void move() {

        for (int index = 0; index < QUANTITY; index++) {
            sections.put(index, "in");
        }

        shuffle();

    }

    public static void shuffle() {

        for (int index = 0; index < QUANTITY; index++) {

            String section = sections.get(index);

            if (!section.equals("in")) {
                continue;
            }

            values.replace(index, RandomGenerator.getDefault().nextInt(1, 7));

        }

    }

    public static void select(int index) {

        sections.replace(index, "trans");

    }

    public static void pass() {

        int rest = 0;

        for (int index = 0; index < QUANTITY; index++) {

            String section = sections.get(index);

            if (!section.equals("in")) {
                continue;
            }

            rest += 1;

        }

        if (rest == 0) {

            turn += 1;

            if (turn >= players.size()) {

                end();

            } else {

                move();

            }

        } else {

            shuffle();

        }

    }

    public static void end() {

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
        return players.get(turn);
    }

}
