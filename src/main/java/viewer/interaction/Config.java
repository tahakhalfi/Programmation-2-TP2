package viewer.interaction;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import controller.Remote;
import manager.Animation;
import manager.Palette;

import java.util.List;

public class Config extends Chapter {

    public Config() {

        VBox root = new VBox();
        root.setId("root");

        super(root);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);
        root.setBackground(new Background(new BackgroundFill(Palette.colorBackground(), null, null)));

        HBox top = new HBox();
        top.setId("top");
        top.setAlignment(Pos.CENTER);
        root.getChildren().add(top);

        HBox middle = new HBox();
        middle.setId("middle");
        middle.setAlignment(Pos.CENTER);
        middle.setSpacing(5);
        root.getChildren().add(middle);

        HBox bottom = new HBox();
        bottom.setId("bottom");
        bottom.setAlignment(Pos.CENTER);
        root.getChildren().add(bottom);

        // TITLE TEXT

        Text text = new Text();
        text.setId("title");
        text.setText("CONFIGURATION");
        text.setFill(Palette.colorTitle());
        text.setFont(Palette.fontTitle());

        top.getChildren().add(text);

        // DECREASE BUTTON

        Button button = new Button();
        button.setId("decrease");
        button.setText("<<");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        //button.setOnMouseClicked(event -> {Remote.playButtonClicked();});

        middle.getChildren().add(button);

        // COUNT BUTTON

        text = new Text();
        text.setId("count");
        text.setText("2");
        text.setFill(Palette.colorTitle());
        text.setFont(Palette.fontTitle());

        middle.getChildren().add(text);

        // INCREASE BUTTON

        button = new Button();
        button.setId("increase");
        button.setText(">>");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        //button.setOnMouseClicked(event -> {Remote.trackButtonClicked();});

        middle.getChildren().add(button);

        // BACK BUTTON

        button = new Button();
        button.setId("back");
        button.setText("BACK");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Remote.backButtonClicked();});

        bottom.getChildren().add(button);

        // START BUTTON



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

}
