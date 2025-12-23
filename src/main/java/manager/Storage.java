package manager;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Storage {
    private char separator;

    public Storage(char separator){
        this.separator = separator;
    }

    // lecture d un fichier csv et retourne une liste de lignes
    public List<List<String>> read(String filename) throws Exception {
        List<List<String>> data = new ArrayList<>();

        // lecture de toutes les lignes du fichier
        List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);

        // separer chaque ligne selon le separateur
        for (String line : lines) {
            String[] parts = line.split(String.valueOf(separator));
            List<String> row = new ArrayList<>();

            for (String part : parts) {
                row.add(part.trim()); // trim() permet d'enlever les espaces
            }
            data.add(row);
        }

        return data;
    }

    // ecriture des donnes dans un fichier CSV

    public void write(String filename, List<List<String>> data) throws Exception {
        List<String> lines = new ArrayList<>();

        // construction de chaque ligne
        for (List<String> row : data) {
            String line = String.join(String.valueOf(separator), row);
            lines.add(line);
        }

        // ecriture de toutes les lignes dans le fichier
        Files.write(Paths.get(filename), lines, StandardCharsets.UTF_8);
    }
}