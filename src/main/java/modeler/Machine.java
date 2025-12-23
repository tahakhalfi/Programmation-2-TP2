package modeler;

import manager.Chronologue;
import manager.Storage;

import java.util.List;

public class Machine {

    public static void saveInfo(String winner, String scores) throws Exception {

        Storage.insert(Chronologue.date());
        Storage.insert(winner);
        Storage.insert(scores);

        Storage.stamp("history.csv");

    }

    public static List<String> loadInfo(int index) throws Exception {

        List<String> content = Storage.read("history.csv");

        if (content == null) {
            return null;
        } else if (index < 0 || index >= content.size()) {
            return null;
        } else {
            return Storage.scan(content.get(index));
        }

    }
}

