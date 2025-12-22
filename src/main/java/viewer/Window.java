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

        chapters.put("menu", menu);
        chapters.put("place", place);
        chapters.put("track", track);

        Chapter focus = menu;

        chapters.put("focus", focus);

        Scene givenScene = new Scene(
                focus.getRoot(),
                1000,
                800
        );

        scene = givenScene;

        givenStage.setTitle("DICE");
        givenStage.setScene(givenScene);

        stage = givenStage;

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

    public static void open() {

        Message.inform("// Window opening...");

        stage.show();
        reveal("focus");

    }

    public static void close() {

        Message.inform("// Window closing...");

        stage.hide();
        conceal();

    }

    public static void advance(String name) {

        conceal();
        reveal(name);

    }

    public static void reveal(String name) {

        Chapter chapter = getChapter(name);

        if (chapter != null) {
            scene.setRoot(chapter.getRoot());
            chapter.open();
            chapters.replace("focus", chapter);
        }

    }

    public static void conceal() {

        Chapter focus = getChapter("focus");

        if (focus != null) {
            focus.close();
            chapters.replace("focus", null);
        }

    }

}
