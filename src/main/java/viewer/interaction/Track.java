package viewer.interaction;

import controller.Remote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import manager.Animation;
import manager.Message;
import manager.Palette;

import java.util.List;

public class Track extends Chapter {

    private ObservableList<GameHistory> historique;

    public Track() {

        VBox root = new VBox();

        super(root);

        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(50);
        root.setPadding(new Insets(10, 50, 10, 50));
        root.setBackground(new Background(new BackgroundFill(Palette.colorBackground(), null, null)));

        Text text = new Text("TRACK");
        text.setId("title");
        text.setFill(Palette.colorTitle());
        text.setFont(Palette.fontTitle());

        TableView<GameHistory> table = new TableView<>();

        TableColumn<GameHistory,String> column1 = new TableColumn<>("date");
        column1.setCellValueFactory(data -> data.getValue().dateProperty());

        TableColumn<GameHistory,String> column2 = new TableColumn<>("player's scores");
        column2.setCellValueFactory(data -> data.getValue().scoresProperty());

        TableColumn<GameHistory,String> column3 = new TableColumn<>("winner");
        column3.setCellValueFactory(data -> data.getValue().winnerProperty());

        table.getColumns().addAll(column1, column2, column3);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        column1.setStyle("-fx-alignment: CENTER;");
        column2.setStyle("-fx-alignment: CENTER;");
        column3.setStyle("-fx-alignment: CENTER;");

        historique = FXCollections.observableArrayList();
        table.setItems(historique);

        HBox bottom = new HBox();
        bottom.setId("bottom");
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(20);
        bottom.setPadding(new Insets(10, 24, 10, 24));

        Button button = new Button("BACK");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Remote.backButtonClicked();});

        bottom.getChildren().add(button);

        button = new Button("REFRESH");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Remote.refreshButtonCliqued();});

        bottom.getChildren().add(button);

        button = new Button("CLEAR");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Remote.clearHistoryButtonCliqued();});

        bottom.getChildren().add(button);

        showInfo("2025-12-22", "Nizar", "Nizar:0 et Taha: 26");
        showInfo("2025-12-23", "Taha", "Nizar:23 et Taha: 5");

        root.getChildren().addAll(text, table, bottom);

    }


    public void open(Runnable onFinished) {

        Pane bottom = (Pane) root.lookup("#bottom");

        List<Node> children = bottom.getChildren();

        Animation.fadein(children, 0, 1, 0.5, 0.1, onFinished);

    }

    public void close(Runnable onFinished) {

        Pane bottom = (Pane) root.lookup("#bottom");

        List<Node> children = bottom.getChildren();

        Animation.fadeout(children, children.size() - 1, -1, 0.5, 0.1, onFinished);

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

    public void clearInfo(){
        historique.clear();
    }


}
