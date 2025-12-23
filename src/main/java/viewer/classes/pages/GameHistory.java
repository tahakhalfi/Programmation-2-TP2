package viewer.classes.pages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
// Chaque objet GameHistory = une partie jouée dans le tableau

public class GameHistory {
    // attributs representant chacune une colonne du tableau
    // StringProperty => javaFX fctionne avec propriete observable
    private final StringProperty date;
    private final StringProperty winner;
    private final StringProperty scores;

    public GameHistory(String date, String winner, String scores) {
        // SimpleStringProperty est l implementation concrete de StringProperty
        // il devienne alors observable
        this.date = new SimpleStringProperty(date);
        this.winner = new SimpleStringProperty(winner);
        this.scores = new SimpleStringProperty(scores);
    }
    // permettent au TableView d acceder aux donnes
    public StringProperty dateProperty() { return this.date; }
    public StringProperty winnerProperty() { return this.winner; }
    public StringProperty scoresProperty() { return this.scores; }
}