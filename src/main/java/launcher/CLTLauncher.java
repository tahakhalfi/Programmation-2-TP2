package launcher;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

import viewer.Window;

public class CLTLauncher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Window.configure(stage);
        Window.open(null);
    }

}
