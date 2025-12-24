package viewer.interaction;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import manager.Palette;
import viewer.Page;

public class Game extends Page {

    public void display() {

        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(5);
        root.setBackground(new Background(new BackgroundFill(Palette.colorBackground(), null, null)));

        HBox top = new HBox();
        top.setId("top");
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(5));

        root.getChildren().add(top);

        HBox middle = new HBox();
        middle.setId("middle");
        middle.setAlignment(Pos.CENTER);
        middle.setSpacing(5);

        root.getChildren().add(middle);

        HBox bottom = new HBox();
        bottom.setId("bottom");
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(5);

        root.getChildren().add(bottom);

        // TURN TEXT

        Text turn = new Text();
        turn.setId("turn");
        turn.setText("TURN #1");
        turn.setFill(Palette.colorComment());
        turn.setFont(Palette.fontComment());

        top.getChildren().add(turn);

        // SPACE REGION

        Region space = new Region();
        HBox.setHgrow(space, Priority.ALWAYS);

        top.getChildren().add(space);

        // CONTROL TEXT

        Text control = new Text();
        control.setId("control");
        control.setText("NONAME");
        control.setFill(Palette.colorComment());
        control.setFont(Palette.fontComment());

        top.getChildren().add(control);

        // TERRITORY VBOX

        VBox territory = new VBox();
        territory.setId("in");
        territory.setAlignment(Pos.CENTER);
        territory.setSpacing(20);
        territory.setBackground(new Background(new BackgroundFill(Palette.colorTerritory(), null, null)));

        middle.getChildren().add(territory);

        // TITLE TEXT

        Text title = new Text();
        title.setId("title");
        title.setText("IN");
        title.setFill(Palette.colorTitle());
        title.setFont(Palette.fontTitle());

        territory.getChildren().add(title);

        // AREA VBOX

        HBox area = new HBox();
        area.setId("area");
        area.setAlignment(Pos.CENTER);
        area.setSpacing(5);

        territory.getChildren().add(area);

        // TRANS VBOX

        // TITLE TEXT

        // AREA VBOX

        // OUT VBOX

        // TITLE TEXT

        // AREA VBOX

        // DONE BUTTON

        super.setRoot(root);

    }

    public void open(Runnable onFinished) {

    }

    public void close(Runnable onFinished) {

    }
}

