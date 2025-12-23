package viewer.classes.pages;

import controller.Remote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import manager.Message;

public class Track extends Chapter {

    private ObservableList<GameHistory> historique;

    public Track() {

        VBox root = new VBox();

        super(root);




        // tout le contenu est placé en haut et centré horizontalement
        root.setAlignment(Pos.TOP_CENTER);
        // espace entre texte et tableau
        root.setSpacing(50);
        // espace entre le contenu et les bords de la scène
        root.setPadding(new Insets(10, 50, 10, 50)); // top, right, bottom, left

        // Texte (titre du tableau)
        Text text = new Text("GAME HISTORY");
        text.setId("title");
        text.setFont(Font.font("Segoe UI", 28));

        /*

        creation du tableau

        le tableau affiche des objets GameHistory
        1 ligne = 1 objet GameHistory

        */

        TableView<GameHistory> table = new TableView<>();

        // creation des colonnes

        TableColumn<GameHistory,String> column1 = new TableColumn<>("date");
        column1.setCellValueFactory(data -> data.getValue().dateProperty());

        TableColumn<GameHistory,String> column2 = new TableColumn<>("player's scores");
        column2.setCellValueFactory(data -> data.getValue().scoresProperty());

        TableColumn<GameHistory,String> column3 = new TableColumn<>("winner");
        column3.setCellValueFactory(data -> data.getValue().winnerProperty());

        // Ajout des colonnes au tableau visible

        table.getColumns().addAll(column1, column2, column3);


        // forcer colonnes a remplir toute largeur colonne

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // centrer le texte dans colonne

        column1.setStyle("-fx-alignment: CENTER;");
        column2.setStyle("-fx-alignment: CENTER;");
        column3.setStyle("-fx-alignment: CENTER;");



        // ajout de donnes ou ObservableList est une liste visible par javaFX
        historique = FXCollections.observableArrayList();
        // le tableau affiche maintenant le contenue de historique
        table.setItems(historique);

        // Boutons
        Button btn1 = new Button("Back to menu");
        Button btn2 = new Button("Refresh");
        Button btn3 = new Button("Clear History");

        // Conteneur horizontal pour les boutons
        HBox buttonsBox = new HBox();
        buttonsBox.setAlignment(Pos.CENTER); // centré horizontalement
        buttonsBox.setSpacing(20);           // espace entre les boutons
        buttonsBox.setPadding(new Insets(10, 24, 10, 24)); // espace au-dessus


        // taille bouttons

        btn1.setPrefWidth(150);
        btn2.setPrefWidth(120);
        btn3.setPrefWidth(150);

        // custumisation des bouttons

        btn1.setStyle(
                "-fx-background-color: #0F4C5C;" +   // rouge
                        "-fx-text-fill: white;" +            // texte blanc
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20;" +              // hauteur / largeur
                        "-fx-background-radius: 8;"           // coins arrondis
        );

        btn2.setStyle(
                "-fx-background-color: #e74c3c;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-padding: 10 20;" +
                        "-fx-background-radius: 8;"
        );

        btn3.setStyle(
                "-fx-background-color: #0F4C5C;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-padding: 10 20;" +
                        "-fx-background-radius: 8;"
        );

        root.setStyle("-fx-background-color: #2c3e50;");

        btn1.setOnMouseClicked(event -> { Remote.backToMenuButtonCliqued();});




        buttonsBox.getChildren().addAll(btn1, btn2, btn3);

        // exemple
        showInfo("2025-12-22", "Nizar", "Nizar:0 et Taha: 26");
        showInfo("2025-12-23", "Taha", "Nizar:23 et Taha: 5");
        hideInfo(1);


        // Ajout au layout
        root.getChildren().addAll(text, table, buttonsBox);


    }


    public void open() {

        Message.inform("// Track chapter opened!");

    }

    public void close() {

        Message.inform("// Track chapter closed!");

    }

    // showInfo methode

    public void showInfo(String date, String winner, String scores){

        // Ajout d'une ligne

        historique.add(new GameHistory(
                date,
                winner,
                scores
        ));

    }
    // hideInfo methode

    public void hideInfo(int index){
        if(index >= 0 && index < historique.size()){
            historique.remove(index);
        }
    }


}
