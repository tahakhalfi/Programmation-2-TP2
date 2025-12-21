package viewer;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.stage.Stage;
import viewer.classes.Page;
import viewer.classes.Game;
import viewer.classes.Home;
import viewer.classes.Track;

public class Window {

    private HashMap<String, Page> pages;

    private Stage stage;

    public Window(Stage stage) {

        this.pages = new HashMap<>();

        pages.put("Home", new Home(this));
        pages.put("Game", new Game(this));
        pages.put("Track", new Track(this));

        this.stage = stage;

    }

    public void open() {

        stage.setTitle("DICE");
        stage.show();

        turn("Home");

    }

    public void close() {

        System.exit(0);

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
