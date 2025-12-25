package manager;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Storage {

    private static LinkedList<String> buffer = new LinkedList<>();

    private static final String CORE = "src/main/savings/";
    private static final char SEPERATOR = ',';

    public static void insert(String data) {
        buffer.addLast(data);
    }

    public static void insert(String[] datas) {
        for (String data: datas) {
            insert(data);
        }
    }

    public static void extract() {
        buffer.removeLast();
    }

    public static void release() {
        buffer.clear();
    }

    public static void engrave(String name, Integer index) {

        List<String> content = read(name);

        if (content == null) {
            return;
        }

        if (index != null) {

            content.set(index, String.join(
                    String.valueOf(SEPERATOR),
                    buffer
            ));

        } else {

            content.addLast(String.join(
                    String.valueOf(SEPERATOR),
                    buffer
            ));

        }

        write(name, content);

    }

    public static void stamp(String name, Integer index) {
        engrave(name, index);
        release();
    }

    public static List<String> scan(String line) {
        return List.of(line.split(String.valueOf(SEPERATOR)));
    }

    public static List<String> read(String name) {

        String route = CORE + name;

        try {
            return Files.readAllLines(Paths.get(route), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static void write(String name, List<String> content) {

        if (content == null) {content = new ArrayList<>();}

        String route = CORE + name;

        try {
            Files.write(Paths.get(route), content, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}