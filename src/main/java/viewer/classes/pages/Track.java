package viewer.classes.pages;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import manager.Message;

public class Track extends Chapter {

    public Track() {

        VBox root = new VBox();

        super(root);

    }

    public void open() {

        Message.inform("// Track chapter opened!");

    }

    public void close() {

        Message.inform("// Track chapter closed!");

    }

}
