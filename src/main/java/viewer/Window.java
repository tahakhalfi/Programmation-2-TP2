package viewer;

import manager.Message;

import viewer.classes.pages.Place;
import viewer.classes.pages.Menu;
import viewer.classes.pages.Chapter;

import javafx.scene.Scene;
import javafx.stage.Stage;
import viewer.classes.pages.Track;

import java.util.HashMap;

public class Window {

    private static Stage stage;
    private static Scene scene;

    private static HashMap<String, Chapter> chapters;

    public static void initiate(Stage givenStage) {

        chapters = new HashMap<>();

        Chapter menu = new Menu();
        Chapter place = new Place();
        Chapter track = new Track();

        chapters.put("Menu", menu);
        chapters.put("Place", place);
        chapters.put("Track", track);

        Scene givenScene = new Scene(
                menu.getRoot(),
                1000,
                800
        );

        givenStage.setTitle("DICE");

        stage = givenStage;
        scene = givenScene;

    }

    public static void open() {

        stage.show();
        Message.inform("Window Opened!");

    }

    public static void close() {

        stage.hide();
        Message.inform("Window Closed!");

    }

    public static Chapter getChapter(String name) {
        return chapters.get(name);
    }

    public static Scene getScene() {
        return scene;
    }

    public static Stage getStage() {
        return stage;
    }

}
