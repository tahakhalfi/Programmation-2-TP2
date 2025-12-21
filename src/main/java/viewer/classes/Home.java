package viewer.classes;

import viewer.Window;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Home extends Page {

    public Home(Window window) {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        super(window, root);

        Text text = new Text();
        text.setId("Title");
        text.setText("DICE");
        this.root.getChildren().add(text);

        Button button = new Button();
        button.setId("Play");
        button.setText("Play");
        this.root.getChildren().add(button);

        button = new Button();
        button.setId("Bundle");
        button.setText("Bundle");
        this.root.getChildren().add(button);

        button = new Button();
        button.setId("Options");
        button.setText("Options");
        this.root.getChildren().add(button);

        button = new Button();
        button.setId("Quit");
        button.setText("Quit");
        this.root.getChildren().add(button);

    }

}
