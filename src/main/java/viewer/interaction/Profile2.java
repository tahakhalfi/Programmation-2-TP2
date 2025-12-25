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
import modeler.usage.Account;
import viewer.Page;

import java.util.List;

public class Profile2 extends Page {

    private Text nameText;
    private Text levelText;
    private Text experienceText;

    private StackPane xpBar;
    private Region xpFill;
    private Text xpText;

    public void display() {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);
        root.setBackground(
                new Background(new BackgroundFill(Palette.colorBackground(), null, null))
        );

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

        // === TEXTS ===
        nameText = new Text();
        levelText = new Text();
        experienceText = new Text();

        nameText.setId("pseudo");
        levelText.setId("level");
        experienceText.setId("experience");

        nameText.setFill(Palette.colorComment());
        levelText.setFill(Palette.colorComment());
        experienceText.setFill(Palette.colorComment());

        nameText.setFont(Palette.fontComment());
        levelText.setFont(Palette.fontComment());
        experienceText.setFont(Palette.fontComment());

        // === XP BAR ===
        xpFill = new Region();
        xpFill.setPrefHeight(16);
        xpFill.setStyle("-fx-background-color: orange; -fx-background-radius: 8;");

        Region xpBackground = new Region();
        xpBackground.setPrefSize(260, 16);
        xpBackground.setStyle(
                "-fx-background-color: rgba(255,255,255,0.3); -fx-background-radius: 8;"
        );

        xpBar = new StackPane(xpBackground, xpFill);
        xpBar.setAlignment(Pos.CENTER_LEFT);

        xpText = new Text();
        xpText.setFill(Palette.colorComment());
        xpText.setFont(Palette.fontComment());

        // MAINTENANT TOUT EXISTE
        updateProfile();

        // === BUTTON ===
        HBox bottom = new HBox();
        bottom.setId("bottom");
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(20);
        bottom.setPadding(new Insets(10, 24, 10, 24));

        Button button = new Button("BACK");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(
                new Background(new BackgroundFill(Palette.colorInvisible(), null, null))
        );

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);
        button.setOnMouseClicked(e -> Remote.backProfileButtonClicked());

        bottom.getChildren().add(button);

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

        int level = Account.getLevel();
        int xp = Account.getExperience();
        int maxXp = level * 50;

        nameText.setText("NAME: " + Account.getName());
        levelText.setText("LEVEL: " + level);
        experienceText.setText("EXPERIENCE:");

        double ratio = (maxXp == 0) ? 0 : Math.min(1.0, (double) xp / maxXp);
        xpFill.setPrefWidth(260 * ratio);

        xpText.setText("XP : " + xp + " / " + maxXp);
    }
}
