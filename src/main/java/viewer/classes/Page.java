package viewer.classes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Page {

    private Scene scene;

    public Page(Pane root) {

        Scene scene = new Scene(
                root,
                1000,
                800
        );

        this.scene = scene;

    }

    public Scene getScene() {
        return this.scene;
    }

    public Pane getRoot() {
        return (Pane) this.scene.getRoot();
    }

    public void open() {
        System.out.println("// Opening Page.");
    }

    public void close() {
        System.out.println("// Closing Page.");
    }

}
