package viewer.classes;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import viewer.Window;

public class Page {

    protected Window window;

    protected Scene scene;
    protected Pane root;

    public Page(Window window, Pane root) {

        this.window = window;

        this.scene = new Scene(root, 1000, 800);
        this.root = root;

    }

    public Scene getScene() {
        return this.scene;
    }

    public Pane getRoot() {
        return this.root;
    }

    public Node getChild(String id) {

        Node child = null;

        for (Node c: this.root.getChildren()) {
            if (c.getId().equals(id)) {
                child = c;
                break;
            }
        }

        return  child;

    }

    public void open() {
        System.out.println("// Opening Page.");
    }

    public void close() {
        System.out.println("// Closing Page.");
    }

}
