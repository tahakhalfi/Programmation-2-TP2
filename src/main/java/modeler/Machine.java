package modeler;

import manager.Chronologue;
import manager.Storage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Machine {

    // saveInfo(winner, scores) méthode qui prend information et l ecrit dans fichier
    // et retourne l index de la ligne ecrite
    public static int saveInfo(String winner, String scores) throws Exception {

        String date = Chronologue.date();

        Storage csv = new Storage(';');
        String filename = "history.csv";

        // Lire les données existantes
        List<List<String>> data = new ArrayList<>();

        if (Files.exists(Paths.get(filename))) {
            data = csv.read(filename);
        }

        // Créer une nouvelle ligne
        List<String> newRow = new ArrayList<>();
        newRow.add(date);
        newRow.add(winner);
        newRow.add(scores);

        // Ajouter la ligne
        data.add(newRow);

        // Écrire dans le fichier
        csv.write(filename, data);

        // Retourner l'index de la ligne ajoutée
        return data.size() - 1;
    }

    // loadInfo(index) methode qui prend un index et retourne la ligne en cet index

    public static List<String> loadInfo(int index) throws Exception {

        Storage csv = new Storage(';');
        String filename = "history.csv";

        // Lire toutes les lignes
        List<List<String>> data = csv.read(filename);

        // Vérifier que l’index est valide
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Index invalide");
        }

        // Retourner la ligne demandée
        return data.get(index);
    }
}

