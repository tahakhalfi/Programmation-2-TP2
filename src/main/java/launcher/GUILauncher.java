package launcher;

import javafx.application.Application;
import javafx.stage.Stage;
import viewer.View;

import java.io.IOException;

public class GUILauncher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        new View(stage);
    }

}
