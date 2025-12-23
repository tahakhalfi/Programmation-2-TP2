package viewer.interaction;

import javafx.scene.layout.Pane;

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
