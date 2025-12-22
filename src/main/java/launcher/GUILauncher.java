package launcher;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

import viewer.Window;

public class GUILauncher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Window.initiate(stage);
        Window.open();
    }

}
