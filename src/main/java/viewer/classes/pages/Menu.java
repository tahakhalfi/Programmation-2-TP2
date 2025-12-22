package viewer.classes.pages;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Menu extends Chapter {

    public Menu() {

        VBox root = new VBox();

        super(root);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setBackground(new Background(new BackgroundFill(
                Color.rgb(255, 189, 97),
                CornerRadii.EMPTY,
                Insets.EMPTY
        )));

        Text text = new Text();
        text.setId("title");
        text.setText("DICE");
        this.root.getChildren().add(text);

        Button button = new Button();
        button.setId("play");
        button.setText("Play");
        this.root.getChildren().add(button);

        button = new Button();
        button.setId("bundle");
        button.setText("Bundle");
        this.root.getChildren().add(button);

        button = new Button();
        button.setId("options");
        button.setText("Options");
        this.root.getChildren().add(button);

        button = new Button();
        button.setId("quit");
        button.setText("Quit");
        this.root.getChildren().add(button);

    }

    public void open() {

    }

    public void close() {

    }

}
