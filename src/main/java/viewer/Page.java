package viewer;

import javafx.scene.layout.VBox;

public class Page {

    protected VBox root;

    public Page() {
        display();
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    public VBox getRoot() {
        return root;
    }

    public void display() {
        setRoot(new VBox());
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
