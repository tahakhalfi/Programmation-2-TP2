package viewer.interaction;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import manager.Palette;
import viewer.Page;

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

        form.getChildren().addAll(name, level, experience);

        root.getChildren().addAll(text, profilePicture, form);

        super.setRoot(root);

    }

    public void open(Runnable onFinished) {

    }

    public void close(Runnable onFinished) {

    }

}
