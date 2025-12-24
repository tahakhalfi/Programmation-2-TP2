package viewer.interaction;

import controller.Remote;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import manager.Animation;
import manager.Palette;
import viewer.Page;

import java.util.List;

public class Profile extends Page {

    public void display() {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);
        root.setBackground(new Background(new BackgroundFill(Palette.colorBackground(), null, null)));

        Text text = new Text("PROFILE");
        text.setId("profile");
        text.setFill(Palette.colorTitle());
        text.setFont(Palette.fontTitle());

        ImageView profilePicture = new ImageView(new Image(getClass().getResourceAsStream("/images/profile_picture.png")));
        profilePicture.setFitWidth(200);
        profilePicture.setFitHeight(200);
        profilePicture.setPreserveRatio(true);

        VBox form = new VBox();
        form.setAlignment(Pos.CENTER);
        form.setSpacing(15);

        Text name = new Text("NAME: ");
        name.setId("pseudo");
        name.setFill(Palette.colorComment());
        name.setFont(Palette.fontComment());

        Text level = new Text("LEVEL: ");
        level.setId("level");
        level.setFill(Palette.colorComment());
        level.setFont(Palette.fontComment());

        Text experience = new Text("EXPERIENCE:");
        experience.setId("experience");
        experience.setFill(Palette.colorComment());
        experience.setFont(Palette.fontComment());

        // button

        HBox bottom = new HBox();
        bottom.setId("bottom");
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(20);
        bottom.setPadding(new Insets(10, 24, 10, 24));

        Button button = new Button("BACK");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> { Remote.backProfileButtonClicked();});

        bottom.getChildren().add(button);

        form.getChildren().addAll(name, level, experience);

        root.getChildren().addAll(text, profilePicture, form, bottom);

        super.setRoot(root);

    }

    public void open(Runnable onFinished) {

        Pane bottom = (Pane) root.lookup("#bottom");

        List<Node> children = bottom.getChildren();

        Animation.fadein(children, 0, 1, 0.5, 0.1, onFinished);

    }

    public void close(Runnable onFinished) {

        Pane bottom = (Pane) root.lookup("#bottom");

        List<Node> children = bottom.getChildren();

        Animation.fadeout(children, children.size() - 1, -1, 0.5, 0.1, onFinished);

    }

}
