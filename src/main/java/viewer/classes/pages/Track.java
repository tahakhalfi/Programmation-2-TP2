package viewer.classes.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import manager.Message;

public class Track extends Chapter {

    public Track() {

        VBox root = new VBox();

        super(root);

        // Configuration du layout VBox (position de text)
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(50); // espace entre texte et tableau
        root.setPadding(new Insets(10, 50, 10, 50)); // top, right, bottom, left

        // Texte
        Text text = new Text("GAME HISTORY");
        text.setId("title");
        text.setFont(Font.font("Segoe UI", 28));

        // Tableau

        TableView<GameHistory> table = new TableView<>();

        // creation des colonnes

        TableColumn<GameHistory,String> column1 = new TableColumn<>("date");
        column1.setCellValueFactory(data -> data.getValue().dateProperty());

        TableColumn<GameHistory,String> column2 = new TableColumn<>("player's scores");
        column2.setCellValueFactory(data -> data.getValue().scoresProperty());  // <-- ici column2

        TableColumn<GameHistory,String> column3 = new TableColumn<>("winner");
        column3.setCellValueFactory(data -> data.getValue().winnerProperty());  // <-- ici column3


        table.getColumns().addAll(column1, column2, column3);

        // ajout de donnes

        ObservableList<GameHistory> historique = FXCollections.observableArrayList();

        historique.add(new GameHistory(
                "2025-12-31",        // date
                "Nizar le Boss",     // winner
                "Nizar: 0 et Taha: 100" // scores
        ));

        table.setItems(historique);
        // forcer colonnes a remplir toute largeur colonne
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // centrer le texte dans colonne
        column1.setStyle("-fx-alignment: CENTER;");
        column2.setStyle("-fx-alignment: CENTER;");
        column3.setStyle("-fx-alignment: CENTER;");
        root.setPadding(new Insets(10, 50, 10, 50)); // top, right, bottom, left



        // Ajout au layout
        root.getChildren().addAll(text, table);





    }

    public void open() {

        Message.inform("// Track chapter opened!");

    }

    public void close() {

        Message.inform("// Track chapter closed!");

    }

}
