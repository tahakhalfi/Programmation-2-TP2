package viewer.interaction;

import controller.Remote;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import manager.Animation;
import manager.Audio;
import manager.Palette;
import viewer.Page;

public class Settings extends Page {

    public void display() {

        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(100);
        root.setPadding(new Insets(10, 50, 10, 50));

        // fond
        root.setBackground(
                new Background(new BackgroundFill(Palette.colorBackground(), null, null))
        );

        // TITRE
        Text text = new Text("AUDIO");
        text.setFill(Palette.colorTitle());
        text.setFont(Palette.fontTitle());

        // TEXTE GENERAL
        Text generalText = new Text("GENERAL");
        generalText.setFill(Palette.colorTitle());
        generalText.setFont(Palette.fontTitle());

        // VALEUR %
        Label volumeValue = new Label("50 %");
        volumeValue.setTextFill(Palette.colorInactive());
        volumeValue.setFont(Palette.fontInactive());

        // SLIDER
        Slider volumeSlider = new Slider(0, 100, 50);
        volumeSlider.setPrefWidth(250);
        volumeSlider.setBlockIncrement(1);

        volumeSlider.setShowTickMarks(true);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setMajorTickUnit(25);
        volumeSlider.setMinorTickCount(4);

        // enlève les couleurs par défaut JavaFX
        volumeSlider.setStyle("""
            -fx-background-color: transparent;
            -fx-control-inner-background: transparent;
            -fx-base: transparent;
            -fx-accent: transparent;
        """);

        // force création du skin
        volumeSlider.applyCss();
        volumeSlider.layout();

        volumeSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            Audio.setVolume(newVal.intValue());
        });

        // barre (blanche)
        Node track = volumeSlider.lookup(".track");
        if (track != null) {
            track.setStyle("""
                -fx-background-color: white;
                -fx-background-radius: 4;
                -fx-pref-height: 6;
            """);
        }

        // partie remplie (blanche)
        Node fill = volumeSlider.lookup(".fill");
        if (fill != null) {
            fill.setStyle("-fx-background-color: white;");
        }

        // curseur (bleu)
        Node thumb = volumeSlider.lookup(".thumb");
        if (thumb != null) {
            thumb.setStyle("""
                -fx-background-color: #1e90ff;
                -fx-background-radius: 100;
                -fx-pref-width: 14;
                -fx-pref-height: 14;
            """);
        }

        // MAJ du texte  %
        volumeSlider.valueProperty().addListener((obs, oldVal, newVal) ->
                volumeValue.setText(newVal.intValue() + " %")
        );

        // Alignement
        HBox sliderBox = new HBox(10, volumeSlider, volumeValue);
        sliderBox.setAlignment(Pos.CENTER_RIGHT);

        HBox generalRow = new HBox(40, generalText, sliderBox);
        generalRow.setAlignment(Pos.CENTER);
        generalRow.setPadding(new Insets(0, 20, 0, 20));

        // boutton BACK
        Button button = new Button("BACK");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(
                new Background(new BackgroundFill(Palette.colorInvisible(), null, null))
        );

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);
        button.setOnMouseClicked(event -> {Audio.playClick(); Remote.backButtonClicked();});

        HBox bottom = new HBox(button);
        bottom.setId("bottom");
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10, 24, 10, 24));

        // root
        root.getChildren().addAll(text, generalRow, bottom);
        super.setRoot(root);
    }

    public void open(Runnable onFinished) {
        Pane bottom = (Pane) root.lookup("#bottom");
        Animation.fadein(bottom.getChildren(), 0, 1, 0.5, 0.1, onFinished);
    }

    public void close(Runnable onFinished) {
        Pane bottom = (Pane) root.lookup("#bottom");
        Animation.fadeout(bottom.getChildren(),
                bottom.getChildren().size() - 1, -1, 0.5, 0.1, onFinished);
    }

}
