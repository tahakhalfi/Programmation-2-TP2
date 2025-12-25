package modeler.game;

import manager.Message;
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

    private static HashMap<String, String> trajectories = new HashMap<>();

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

        for (int i = 0; i < scale; i++) {
            players.add(new Player("Player #" + i));
        }

        for (int index = 0; index < QUANTITY; index++) {
            values.put(index, null);
        }

        for (int index = 0; index < QUANTITY; index++) {
            sections.put(index, null);
        }

        trajectories.put("in", null);
        trajectories.put("trans", null);
        trajectories.put("out", null);

        active = true;
        turn = 0;

        arrange();
        establish();

    }

    public static void establish() {

        shuffle();
        flowate();

    }

    public static void arrange() {

        for (int index = 0; index < QUANTITY; index++) {
            sections.replace(index, "in");
        }

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

    public static void flowate() {

        trajectories.replace("in", "trans");
        trajectories.replace("trans", "in");
        trajectories.replace("out", null);

    }

    public static void unflowate() {

        trajectories.replace("in", null);
        trajectories.replace("trans", "out");
        trajectories.replace("out", null);

    }

    public static int count(String section) {

        int total = 0;

        for (int index = 0; index < QUANTITY; index++) {

            if (sections.get(index).equals(section)) {
                total += 1;
            }

        }

        return total;

    }

    public static int sum(String section) {

        int total = 0;

        for (int index = 0; index < QUANTITY; index++) {

            if (sections.get(index).equals(section)) {
                total += values.get(index);
            }

        }

        return total;

    }

    public static void select(int index) {

        String now = sections.get(index);

        if (now == null) {
            return;
        }

        String after = trajectories.get(now);

        if (after == null) {
            return;
        }

        sections.replace(index, after);

    }

    public static void transit() {

        unflowate();

        for (int index = 0; index < QUANTITY; index++) {
            select(index);
        }

        if (count("in") == 0) {

            Player player = players.get(turn);

            player.setScore(sum("out"));

            int next = turn + 1;

            if (next >= players.size()) {

                active = false;
                turn = -1;

                conclude();

            } else {

                active = true;
                turn = next;

                arrange();
                establish();

            }

        } else {

            establish();

        }

    }

    public static void conclude() {

        Player winner = null;

        for (int index = 0; index < players.size(); index++) {

            Player player = players.get(index);

            if (winner == null || player.getScore() > winner.getScore()) {
                winner = player;
            }

        }

        if (winner != null) {

        }



    }

    public static int getTurn() {
        return turn;
    }

    public static String getName() {
        return players.get(turn).getName();
    }

    public static int getQuantity() {
        return QUANTITY;
    }

    public static String getSection(Integer index) {
        return sections.get(index);
    }

    public static Integer getValue(Integer index) {
        return values.get(index);
    }

    public static boolean getAccess() {
        return count("trans") > 0;
    }

}
