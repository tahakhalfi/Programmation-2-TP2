package modeler.memoire;

import manager.Chronologue;
import manager.Storage;

import java.util.ArrayList;
import java.util.List;

public class History {

    public static void save(String name, String score) {

        if (name == null) {name = "---";}
        if (score == null) {name = "---";}

        Storage.insert(Chronologue.date());
        Storage.insert(name);
        Storage.insert(score);

        Storage.stamp("history.csv", null);

    }

    public static void clear() {

        Storage.write("history.csv", null);

    }

    public static List<List<String>> copy() {

        List<String> content = Storage.read("history.csv");

        if (content == null) {
            return null;
        }

        List<List<String>> table = new ArrayList<>(content.size());

        for (int index = 0; index < content.size(); index++) {
            table.add(Storage.scan(content.get(index)));
        }

        return table;

    }

}

