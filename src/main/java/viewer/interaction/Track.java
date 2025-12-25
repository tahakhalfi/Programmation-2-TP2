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
import javafx.scene.text.Text;
import manager.Animation;
import manager.Palette;
import viewer.Log;
import viewer.Page;

import java.util.List;

public class Track extends Page {

    private static ObservableList<Log> historique;

    public void display() {

        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(50);
        root.setPadding(new Insets(10, 50, 10, 50));
        root.setBackground(new Background(new BackgroundFill(Palette.colorBackground(), null, null)));

        Text text = new Text("TRACK");
        text.setId("title");
        text.setFill(Palette.colorTitle());
        text.setFont(Palette.fontTitle());

        TableView<Log> table = new TableView<>();

        TableColumn<Log,String> column1 = new TableColumn<>("DATE");
        column1.setCellValueFactory(data -> data.getValue().dateProperty());

        TableColumn<Log,String> column2 = new TableColumn<>("WINNER");
        column2.setCellValueFactory(data -> data.getValue().winnerProperty());

        TableColumn<Log,String> column3 = new TableColumn<>("SCORE");
        column3.setCellValueFactory(data -> data.getValue().scoresProperty());

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
        button.setId("back");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Remote.backButtonClicked();});

        bottom.getChildren().add(button);

        button = new Button("CLEAR");
        button.setId("clear");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Remote.clearButtonClicked();});

        bottom.getChildren().add(button);

        root.getChildren().addAll(text, table, bottom);

        super.setRoot(root);

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

    public void refresh(List<List<String>> table) {

        historique.clear();

        if (table == null) {
            return;
        }

        for (int index = 0; index < table.size(); index++) {

            List<String> data = table.get(index);

            if (data == null || data.size() != 3) {
                continue;
            }

            String date = data.get(0);
            String name = data.get(1);
            String score = data.get(2);

            historique.add(new Log(
                    date,
                    name,
                    score
            ));

        }

    }



}
