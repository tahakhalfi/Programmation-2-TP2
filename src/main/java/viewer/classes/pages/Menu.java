package viewer.classes.pages;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import manager.Chronologue;
import manager.Iteration;
import manager.Message;

import controller.Remote;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

import java.util.List;

public class Menu extends Chapter {

    public Menu() {

        VBox root = new VBox();
        root.setId("root");

        super(root);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);
        root.setBackground(new Background(new BackgroundFill(
                Color.rgb(255, 189, 97),
                CornerRadii.EMPTY,
                Insets.EMPTY
        )));

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
        text.setText("DICE");
        text.setFill(Color.WHITE);
        text.setFont(Font.font(
                "Franklin Gothic Demi",
                36
        ));
        top.getChildren().add(text);

        // PLAY BUTTON

        Button button = new Button();
        button.setId("play");
        button.setText("PLAY");
        button.setTextFill(Color.WHITE);
        button.setFont(Font.font(
                "Franklin Gothic Demi",
                18
        ));
        button.setBackground(new Background(new BackgroundFill(
                Color.TRANSPARENT,
                null,
                null
        )));

        button.setOnMouseEntered(this::mouseEnter);
        button.setOnMouseExited(this::mouseLeave);
        button.setOnMouseClicked(event -> {Remote.playButtonClicked();});

        bottom.getChildren().add(button);

        // BUNDLE BUTTON

        button = new Button();
        button.setId("bundle");
        button.setText("BUNDLE");
        button.setTextFill(Color.WHITE);
        button.setFont(Font.font(
                "Franklin Gothic Demi",
                18
        ));
        button.setBackground(new Background(new BackgroundFill(
                Color.TRANSPARENT,
                null,
                null
        )));

        button.setOnMouseEntered(this::mouseEnter);
        button.setOnMouseExited(this::mouseLeave);
        button.setOnMouseClicked(event -> {Remote.bundleButtonClicked();});

        bottom.getChildren().add(button);

        // TRACK BUTTON

        button = new Button();
        button.setId("track");
        button.setText("TRACK");
        button.setTextFill(Color.WHITE);
        button.setFont(Font.font(
                "Franklin Gothic Demi",
                18
        ));
        button.setBackground(new Background(new BackgroundFill(
                Color.TRANSPARENT,
                null,
                null
        )));

        button.setOnMouseEntered(this::mouseEnter);
        button.setOnMouseExited(this::mouseLeave);
        button.setOnMouseClicked(event -> {Remote.trackButtonClicked();});

        bottom.getChildren().add(button);

        // OPTIONS BUTTON

        button = new Button();
        button.setId("options");
        button.setText("OPTIONS");
        button.setTextFill(Color.WHITE);
        button.setFont(Font.font(
                "Franklin Gothic Demi",
                18
        ));
        button.setBackground(new Background(new BackgroundFill(
                Color.TRANSPARENT,
                null,
                null
        )));

        button.setOnMouseEntered(this::mouseEnter);
        button.setOnMouseExited(this::mouseLeave);
        button.setOnMouseClicked(event -> {Remote.optionsButtonClicked();});

        bottom.getChildren().add(button);

        // QUIT BUTTON

        button = new Button();
        button.setId("quit");
        button.setText("QUIT");
        button.setTextFill(Color.WHITE);
        button.setFont(Font.font(
                "Franklin Gothic Demi",
                18
        ));
        button.setBackground(new Background(new BackgroundFill(
                Color.TRANSPARENT,
                null,
                null
        )));

        button.setOnMouseEntered(this::mouseEnter);
        button.setOnMouseExited(this::mouseLeave);
        button.setOnMouseClicked(event -> {Remote.quitButtonClicked();});

        bottom.getChildren().add(button);

    }

    public void mouseEnter(MouseEvent event) {

        Button button = (Button) event.getSource();

        button.setFont(Font.font(
                button.getFont().getName(),
                20
        ));

        button.setTextFill(Color.rgb(230, 230, 230));

    }

    public void mouseLeave(MouseEvent event) {

        Button button = (Button) event.getSource();

        button.setFont(Font.font(
                button.getFont().getName(),
                18
        ));

        button.setTextFill(Color.WHITE);

    }

    public void open(Runnable onFinished) {

        Message.inform("// Menu opening...");

    }

    public void close(Runnable onFinished) {

        Iteration iteration = new Iteration() {
            public void next(ObservableList<Node> children, int index, Runnable onFinished) {

                if (index >= children.size()) {
                    if (onFinished != null) {
                        onFinished.run();
                    }
                    return;
                }

                Button button = (Button) children.get(index);

                FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), button);
                fadeOut.setFromValue(1.0); // fully visible
                fadeOut.setToValue(0.0);   // fully transparent
                fadeOut.play();

                this.next(children, index + 1, onFinished);

            }
        };

        VBox bottom = (VBox) root.lookup("#bottom");

        iteration.next(bottom.getChildren(), 0, onFinished);

    }

}
