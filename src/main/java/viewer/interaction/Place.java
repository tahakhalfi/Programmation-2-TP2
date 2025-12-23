package viewer.interaction;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Place extends Chapter {

    public Place() {

        VBox root = new VBox();

        super(root);

        // Tout le contenu verticalement centré et aligné en haut
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(20); // espacement vertical entre sections
        root.setPadding(new Insets(20, 50, 20, 50));

        // premier texte
        Text currentPlayerText = new Text("Current Player: Test");
        currentPlayerText.setFont(Font.font("Segoe UI", 28));
        currentPlayerText.setFill(Color.web("#2c3e50"));

        // deuxieme texte
        Text currentScoreText = new Text("Current Score: 0");
        currentScoreText.setFont(Font.font("Segoe UI", 18));
        currentScoreText.setFill(Color.web("#34495e"));

        //  best/worst score place horizontalement
        HBox scoreBox = new HBox();
        scoreBox.setAlignment(Pos.CENTER);
        scoreBox.setSpacing(50); // espace entre les deux textes

        Text bestScoreText = new Text("Best Score: -- (no player yet)");
        bestScoreText.setFont(Font.font("Verdana", 14));
        bestScoreText.setFill(Color.GREEN);

        Text worstScoreText = new Text("Worst Score: -- (no player yet)");
        worstScoreText.setFont(Font.font("Verdana", 14));
        worstScoreText.setFill(Color.RED);

        scoreBox.getChildren().addAll(bestScoreText, worstScoreText);

        // Ajout au root
        root.getChildren().addAll(currentPlayerText, currentScoreText, scoreBox);


    }

    public void open(Runnable onFinished) {

    }

    public void close(Runnable onFinished) {

    }
}

