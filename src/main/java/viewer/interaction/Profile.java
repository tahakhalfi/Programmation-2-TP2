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
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(50);
        root.setBackground(new Background(new BackgroundFill(Palette.colorBackground(), null, null)));

        Text text = new Text("PROFILE");
        text.setId("profile");
        text.setFill(Palette.colorTitle());
        text.setFont(Palette.fontTitle());

        // image profil

        Image profileImage = new Image(
                getClass().getResourceAsStream("/images/profile_picture.png")
        );

        ImageView profilePicture = new ImageView(profileImage);
        profilePicture.setFitWidth(200);
        profilePicture.setFitHeight(200);
        profilePicture.setPreserveRatio(true);

        Text name = new Text("NAME: ");
        name.setId("pseudo");
        name.setFill(Palette.colorText());
        name.setFont(Palette.fontTitle());

        Text level = new Text("LEVEL: ");
        level.setId("level");
        level.setFill(Palette.colorText());
        level.setFont(Palette.fontTitle());

        Text experience = new Text("EXPERIENCE:");
        experience.setId("experience");
        experience.setFill(Palette.colorText());
        experience.setFont(Palette.fontTitle());


        root.getChildren().addAll(text, profilePicture, name, level, experience);

        super.setRoot(root);

    }




    public void open(Runnable onFinished) {

    }

    public void close(Runnable onFinished) {

    }

}
