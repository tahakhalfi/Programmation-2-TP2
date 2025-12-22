package viewer.classes.pages;

import javafx.scene.layout.Pane;
import manager.Message;

public class Chapter {

    protected Pane root;

    public Chapter(Pane root) {
        this.root = root;
    }

    public Pane getRoot() {
        return this.root;
    }

    public void open(Runnable onFinished) {

        if (onFinished != null) {
            onFinished.run();
        }

    }

    public void close(Runnable onFinished) {

        if (onFinished != null) {
            onFinished.run();
        }

    }

}
