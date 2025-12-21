package viewer.classes.pages;

import javafx.scene.layout.Pane;

public class Chapter {

    protected Pane root;

    public Chapter(Pane root) {
        this.root = root;
    }

    public Pane getRoot() {
        return this.root;
    }

    public void open() {
        System.out.println("// Opening Page.");
    }

    public void close() {
        System.out.println("// Closing Page.");
    }

}
