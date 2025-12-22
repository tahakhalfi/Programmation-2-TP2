package viewer.classes.pages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
// class for line of table

public class GameHistory {
    private final StringProperty date;
    private final StringProperty winner;
    private final StringProperty scores;

    public GameHistory(String date, String winner, String scores) {
        this.date = new SimpleStringProperty(date);
        this.winner = new SimpleStringProperty(winner);
        this.scores = new SimpleStringProperty(scores);
    }

    public StringProperty dateProperty() { return date; }
    public StringProperty winnerProperty() { return winner; }
    public StringProperty scoresProperty() { return scores; }
}