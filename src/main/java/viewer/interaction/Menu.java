package viewer.interaction;

import javafx.scene.Node;
import manager.Animation;

import controller.Remote;
import javafx.scene.layout.*;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import manager.Audio;
import manager.Palette;
import viewer.Page;

import java.util.List;

public class Menu extends Page {

    public void display() {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);
        root.setBackground(new Background(new BackgroundFill(Palette.colorBackground(), null, null)));

        HBox top = new HBox();
        top.setId("top");
        top.setAlignment(Pos.CENTER);
        root.getChildren().add(top);

        VBox bottom = new VBox();
        bottom.setId("bottom");
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(5);
        root.getChildren().add(bottom);

        // TITLE TEXT

        Text text = new Text();
        text.setId("title");
        text.setText("DICE PEACH");
        text.setFill(Palette.colorTitle());
        text.setFont(Palette.fontTitle());

        top.getChildren().add(text);

        // PLAY BUTTON

        Button button = new Button();
        button.setId("play");
        button.setText("PLAY");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Audio.playClick(); Remote.playButtonClicked();});

        bottom.getChildren().add(button);

        // PROFILE BUTTON

        button = new Button();
        button.setId("profile");
        button.setText("PROFILE");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Audio.playClick(); Remote.profileButtonClicked();});

        bottom.getChildren().add(button);

        // TRACK BUTTON

        button = new Button();
        button.setId("track");
        button.setText("TRACK");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Audio.playClick(); Remote.trackButtonClicked();});

        bottom.getChildren().add(button);

        // TRACK BUTTON

        button = new Button();
        button.setId("settings");
        button.setText("SETTINGS");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Audio.playClick(); Remote.settingsButtonClicked();});

        bottom.getChildren().add(button);

        // QUIT BUTTON

        button = new Button();
        button.setId("quit");
        button.setText("QUIT");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Audio.playClick(); Remote.quitButtonClicked();});

        bottom.getChildren().add(button);

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

}
