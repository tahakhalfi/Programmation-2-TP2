package viewer.interaction;

import controller.Remote;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import manager.Animation;
import manager.Palette;
import modeler.usage.Account;
import viewer.Page;

import java.util.List;

public class Profile extends Page {

    private static final double XP_BAR_WIDTH = 260;
    private static final double XP_BAR_HEIGHT = 16;

    private Text nameText;
    private Text levelText;
    private Text experienceText;

    private Region xpFill;
    private Text xpText;

    public void display() {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);
        root.setBackground(new Background(
                new BackgroundFill(Palette.colorBackground(), null, null)
        ));

        Text title = new Text("PROFILE");
        title.setId("profile");
        title.setFill(Palette.colorTitle());
        title.setFont(Palette.fontTitle());

        ImageView profilePicture = new ImageView(
                new Image(getClass().getResourceAsStream("/images/profile_picture.png"))
        );
        profilePicture.setFitWidth(200);
        profilePicture.setFitHeight(200);
        profilePicture.setPreserveRatio(true);

        VBox form = new VBox();
        form.setAlignment(Pos.CENTER);
        form.setSpacing(15);

        nameText = new Text();
        levelText = new Text();
        experienceText = new Text();

        nameText.setFill(Palette.colorComment());
        levelText.setFill(Palette.colorComment());
        experienceText.setFill(Palette.colorComment());

        nameText.setFont(Palette.fontComment());
        levelText.setFont(Palette.fontComment());
        experienceText.setFont(Palette.fontComment());

        /* ================= BARRE XP ================= */

        // contour barre xp

        StackPane xpBackground = new StackPane();
        xpBackground.setMinSize(XP_BAR_WIDTH, XP_BAR_HEIGHT);
        xpBackground.setMaxSize(XP_BAR_WIDTH, XP_BAR_HEIGHT);
        xpBackground.setStyle(
                "-fx-background-color: #ffffff;" +
                "-fx-background-radius: 6;"
        );

        // jauge

        xpFill = new Region();
        xpFill.setMinHeight(XP_BAR_HEIGHT);
        xpFill.setMinHeight(XP_BAR_HEIGHT);
        xpFill.setStyle(
                "-fx-background-color: #00d9ff;" +
                "-fx-background-radius: 6;"
        );

        xpBackground.setAlignment(Pos.CENTER_LEFT);
        xpBackground.getChildren().add(xpFill);

        StackPane xpBar = new StackPane(xpBackground);

        xpText = new Text();
        xpText.setFill(Palette.colorComment());
        xpText.setFont(Palette.fontComment());

        updateProfile();

        /* ================= BOUTON ================= */

        HBox bottom = new HBox();
        bottom.setId("bottom");
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10, 24, 10, 24));

        Button back = new Button("BACK");
        back.setTextFill(Palette.colorInactive());
        back.setFont(Palette.fontInactive());
        back.setBackground(new Background(
                new BackgroundFill(Palette.colorInvisible(), null, null)
        ));

        back.setOnMouseEntered(Animation::activate);
        back.setOnMouseExited(Animation::inactivate);

        back.setOnMouseClicked(e -> Remote.backButtonClicked());

        bottom.getChildren().add(back);

        form.getChildren().addAll(
                nameText,
                levelText,
                experienceText,
                xpBar,
                xpText
        );

        root.getChildren().addAll(
                title,
                profilePicture,
                form,
                bottom
        );

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

    private void updateProfile() {

        nameText.setText("NAME: " + Account.getName());
        levelText.setText("LEVEL: " + Account.getLevel());
        experienceText.setText("EXPERIENCE:");

        int experience = Account.getExperience();
        int maxExperience = Account.getMaxExperience();

        double ratio = (double) experience / maxExperience;
        int length = (int) ((XP_BAR_WIDTH - 4) * ratio);

        xpFill.setMinWidth(length);
        xpFill.setMaxWidth(length);

        xpText.setText("XP : " + experience + " / " + maxExperience);

    }
}

