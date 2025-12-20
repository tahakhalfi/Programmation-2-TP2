package viewer;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox();

        Scene scene = new Scene(
                root,
                1000,
                800
        );

        stage.setTitle("PANAMA");
        stage.setScene(scene);
        stage.show();

    }

}
