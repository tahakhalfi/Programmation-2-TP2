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

    public void open() {
        Message.inform("// Opening Page.");
    }

    public void close() {
        Message.inform("// Closing Page.");
    }

}
