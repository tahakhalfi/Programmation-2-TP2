package viewer.interaction;

import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import manager.Palette;
import viewer.Page;

public class Profile extends Page {

    public void display() {

        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(5);
        root.setBackground(new Background(new BackgroundFill(Palette.colorBackground(), null, null)));



        super.setRoot(null);

    }

    public void open(Runnable onFinished) {

    }

    public void close(Runnable onFinished) {

    }

}
