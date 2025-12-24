package viewer;

import viewer.interaction.*;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class Window {

    private static Stage stage;
    private static Scene scene;
    private static HashMap<String, Page> pages;

    public static void configure(Stage givenStage) {

        pages = new HashMap<>();

        Menu menu = new Menu();
        Config config = new Config();
        Game game = new Game();
        Profile profile = new Profile();
        Track track = new Track();

        pages.put("menu", menu);
        pages.put("config", config);
        pages.put("game", game);
        pages.put("profile", profile);
        pages.put("track", track);

        Page focus = menu;

        pages.put("focus", focus);

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

    public static Page getPage(String name) {
        return pages.get(name);
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

            if (onFinished != null) {
                onFinished.run();
            }

        });

    }

    public static void advance(String name, Runnable onFinished) {

        conceal(() -> {
            reveal(name, onFinished);
        });

    }

    public static void reveal(String name, Runnable onFinished) {

        Page chapter = getPage(name);

        if (chapter != null) {
            scene.setRoot(chapter.getRoot());
            pages.replace("focus", chapter);
            chapter.open(onFinished);
        }

    }

    public static void conceal(Runnable onFinished) {

        Page focus = getPage("focus");

        if (focus != null) {
            pages.replace("focus", null);
            focus.close(onFinished);
        }

    }

}
