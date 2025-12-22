package viewer;

import manager.Chronologue;
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

    public static void open(Runnable onFinished) {

        stage.show();
        reveal("focus", onFinished);

    }

    public static void close(Runnable onFinished) {

        conceal(() -> {
            stage.hide();
            onFinished.run();
        });

    }

    public static void advance(String name, Runnable onFinished) {
        conceal(() -> {reveal(name, onFinished);});
    }

    public static void reveal(String name, Runnable onFinished) {

        Chapter chapter = getChapter(name);

        if (chapter != null) {
            scene.setRoot(chapter.getRoot());
            chapters.replace("focus", chapter);
            chapter.open(onFinished);
        }

    }

    public static void conceal(Runnable onFinished) {

        Chapter focus = getChapter("focus");

        if (focus != null) {
            chapters.replace("focus", null);
            focus.close(onFinished);
        }

    }

}
