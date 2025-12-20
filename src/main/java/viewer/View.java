package viewer;

import java.util.HashMap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import viewer.classes.Page;
import viewer.classes.pages.Game;
import viewer.classes.pages.Home;
import viewer.classes.pages.Track;

public class View {

    private Stage stage;

    private HashMap<String, Page> pages = new HashMap<>();

    public View(Stage stage) {

        this.stage = stage;

        stage.setTitle("DICE");
        stage.show();

        pages.put("Home", new Home());
        pages.put("Game", new Game());
        pages.put("Track", new Track());

        turn("Home");

    }

    public Stage getStage() {
        return this.stage;
    }

    public Page getPage(String name) {
        return pages.get(name);
    }

    public void turn(String name) {

        pull("Current");
        push(name);

    }

    public void push(String name) {

        Page page = getPage(name);

        if (page == null) {
            return;
        }

        Scene scene = page.getScene();

        if (this.stage.getScene() != null) {
            return;
        }

        page.open();

        this.stage.setScene(scene);

        pages.replace("Current", page);

    }

    public void pull(String name) {

        Page page = getPage(name);

        if (page == null) {
            return;
        }

        Scene scene = page.getScene();

        if (this.stage.getScene() != scene) {
            return;
        }

        page.close();

        this.stage.setScene(null);

        pages.replace("Current", null);

    }

}
