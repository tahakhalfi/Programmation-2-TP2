package modeler.game;

import modeler.usage.Account;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.random.RandomGenerator;

public class Mechanism {

    private static LinkedList<Player> players = new LinkedList<>();
    private static int scale = 1;

    private static final int MIN_PLAYERS = 1;
    private static final int MAX_PLAYERS = 6;

    private static boolean active = false;
    private static int round = -1;

    private static Player winner = null;

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

    public static void start() {

        players.add(new Player(Account.getName()));

        for (int i = 0; i < scale; i++) {
            players.add(new Player("Player #" + (i + 2)));
        }

        for (int index = 0; index < QUANTITY; index++) {
            sections.put(index, null);
        }

        for (int index = 0; index < QUANTITY; index++) {
            values.put(index, null);
        }

        trajectories.put("in", null);
        trajectories.put("trans", null);
        trajectories.put("out", null);

        active = true;
        round = 0;
        winner = null;

        arrange();
        establish();

    }

    public static void end() {

        players.clear();

        values.clear();
        sections.clear();

        trajectories.clear();

        active = false;
        round = -1;

        winner = null;

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

                int value = values.get(index);

                if (value != 3) {
                    total += values.get(index);
                }

            }

        }

        return total;

    }

    public static void select(int index) {

        if (!active) {
            return;
        }

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

        if (!active) {
            return;
        }

        unflowate();

        for (int index = 0; index < QUANTITY; index++) {
            select(index);
        }

        if (count("in") == 0) {

            Player player = players.get(round);

            player.setScore(sum("out"));

            int next = round + 1;

            if (next >= players.size()) {

                active = false;

                conclude();

            } else {

                round = next;

                arrange();
                establish();

            }

        } else {

            establish();

        }

    }

    public static void conclude() {

        int minimum = (QUANTITY * 6) + 1;
        Player selected = null;

        for (int index = 0; index < players.size(); index++) {

            Player player = players.get(index);

            int score = player.getScore();

            if (score < minimum) {
                minimum = score;
                selected = player;
            } else if (score == minimum) {
                selected = null;
            }

        }

        winner = selected;

    }

    public static boolean getActive() {
        return active;
    }

    public static int getTurn() {
        return round + 1;
    }

    public static Player getWinner() {
        return winner;
    }

    public static String getName() {
        return players.get(round).getName();
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
