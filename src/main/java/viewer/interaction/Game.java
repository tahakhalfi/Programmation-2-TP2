package viewer.interaction;

import controller.Remote;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.Animation;
import manager.Palette;
import viewer.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import java.util.random.RandomGenerator;

public class Game extends Page {

    private ArrayList<Button> selections;

    private static final HashMap<Integer, Image> FIGURES = new HashMap<>(Map.of(
            1, new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice1.png"))),
            2, new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice2.png"))),
            3, new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice3.png"))),
            4, new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice4.png"))),
            5, new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice5.png"))),
            6, new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice6.png")))
    ));

    public void display() {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.setBackground(new Background(new BackgroundFill(Palette.colorBackground(), null, null)));

        HBox top = new HBox();
        top.setId("top");
        top.setAlignment(Pos.CENTER);

        root.getChildren().add(top);

        Region space = new Region();
        VBox.setVgrow(space, Priority.ALWAYS);

        root.getChildren().add(space);

        HBox middle = new HBox();
        middle.setId("middle");
        middle.setAlignment(Pos.CENTER);
        middle.setSpacing(5);

        root.getChildren().add(middle);

        space = new Region();
        VBox.setVgrow(space, Priority.ALWAYS);

        root.getChildren().add(space);

        HBox bottom = new HBox();
        bottom.setId("bottom");
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(5);

        root.getChildren().add(bottom);

        // TURN TEXT

        Text turn = new Text();
        turn.setId("turn");
        turn.setText("");
        turn.setFill(Palette.colorComment());
        turn.setFont(Palette.fontComment());

        top.getChildren().add(turn);

        // SPACE REGION

        space = new Region();
        space.setId("space");
        HBox.setHgrow(space, Priority.ALWAYS);

        top.getChildren().add(space);

        // NAME TEXT

        Text name = new Text();
        name.setId("name");
        name.setText("");
        name.setFill(Palette.colorComment());
        name.setFont(Palette.fontComment());

        top.getChildren().add(name);

        // TERRITORY VBOX

        VBox territory = new VBox();
        territory.setId("in");
        territory.setMinSize(300, 600);
        territory.setAlignment(Pos.TOP_CENTER);
        territory.setPadding(new Insets(20));
        territory.setSpacing(20);
        territory.setBackground(new Background(new BackgroundFill(Palette.colorTerritory(), null, null)));

        middle.getChildren().add(territory);

        // TITLE TEXT

        Text title = new Text();
        title.setId("title");
        title.setText("IN");
        title.setFill(Palette.colorTitle());
        title.setFont(Palette.fontTitle());

        territory.getChildren().add(title);

        // AREA VBOX

        VBox area = new VBox();
        area.setId("area");
        area.setAlignment(Pos.CENTER);
        area.setSpacing(5);

        territory.getChildren().add(area);

        // TERRITORY VBOX

        territory = new VBox();
        territory.setId("trans");
        territory.setMinSize(150, 600);
        territory.setAlignment(Pos.TOP_CENTER);
        territory.setPadding(new Insets(20));
        territory.setSpacing(20);
        territory.setBackground(new Background(new BackgroundFill(Palette.colorTerritory(), null, null)));

        middle.getChildren().add(territory);

        // TITLE TEXT

        title = new Text();
        title.setId("title");
        title.setText("⇄");
        title.setFill(Palette.colorTitle());
        title.setFont(Palette.fontTitle());

        territory.getChildren().add(title);

        // AREA VBOX

        area = new VBox();
        area.setId("area");
        area.setAlignment(Pos.CENTER);
        area.setSpacing(5);

        territory.getChildren().add(area);

        // TERRITORY VBOX

        territory = new VBox();
        territory.setId("out");
        territory.setMinSize(300, 600);
        territory.setAlignment(Pos.TOP_CENTER);
        territory.setPadding(new Insets(20));
        territory.setSpacing(20);
        territory.setBackground(new Background(new BackgroundFill(Palette.colorTerritory(), null, null)));

        middle.getChildren().add(territory);

        // TITLE TEXT

        title = new Text();
        title.setId("title");
        title.setText("OUT");
        title.setFill(Palette.colorTitle());
        title.setFont(Palette.fontTitle());

        territory.getChildren().add(title);

        // AREA VBOX

        area = new VBox();
        area.setId("area");
        area.setAlignment(Pos.CENTER);
        area.setSpacing(5);

        territory.getChildren().add(area);

        // DONE BUTTON

        Button button = new Button();
        button.setId("done");
        button.setText("DONE");
        button.setTextFill(Palette.colorInactive());
        button.setFont(Palette.fontInactive());
        button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

        button.setOnMouseEntered(Animation::activate);
        button.setOnMouseExited(Animation::inactivate);

        button.setOnMouseClicked(event -> {Remote.doneButtonClicked();});

        bottom.getChildren().add(button);

        selections = new ArrayList<>(6);

        super.setRoot(root);

    }

    public void store(int quantity) {

        for (int index = 0; index < quantity; index++) {

            ImageView view = new ImageView();
            view.setImage(null);
            view.setFitWidth(50);
            view.setFitHeight(50);
            view.setPreserveRatio(true);
            view.setSmooth(true);

            Button selection = new Button();
            selection.setGraphic(view);
            selection.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

            int i = index;

            selection.setOnMouseClicked(event -> {Remote.selectionButtonClicked(i);});

            selections.add(selection);

        }

    }

    public void empty() {

        for (int index = 0; index < selections.size(); index++) {

            Button selection = selections.get(index);

            if (selection == null) {
                continue;
            }

            selection.setOnMouseClicked(null);

            Pane area = (Pane) selection.getParent();

            if (area == null) {
                return;
            }

            area.getChildren().remove(selection);

        }

        selections.clear();

    }

    public void place(Integer index, String section) {

        if (index < 0 || index > selections.size() - 1) {
            return;
        }

        Button selection = selections.get(index);

        if (selection == null) {
            return;
        }

        Pane now = (Pane) selection.getParent();

        if (now != null) {
            now.getChildren().remove(selection);
        }

        if (section == null) {
            return;
        }

        Pane territory = (Pane) root.lookup("#middle").lookup("#" + section);

        if (territory == null) {
            return;
        }

        Pane after = (Pane) territory.lookup("#area");

        if (after == null) {
            return;
        }

        after.getChildren().add(selection);

    }

    public void flicker(Integer index, Integer time, Runnable onFinished) {

        if (time > 0) {

            Integer value = RandomGenerator.getDefault().nextInt(1, 7);

            present(index, value);

            Animation.pause(0.1, () -> {
                flicker(index, time - 1, onFinished);
            });

        } else {

            if (onFinished != null) {
                onFinished.run();
            }

        }



    }

    public void present(Integer index, Integer value) {

        if (index < 0 || index > selections.size() - 1) {
            return;
        }

        Button selection = selections.get(index);

        if (selection == null) {
            return;
        }

        ImageView view = (ImageView) selection.getGraphic();

        if (view == null) {
            return;
        }

        view.setImage(null);

        if (value == null) {
            return;
        }

        Image figure = FIGURES.get(value);

        if (figure == null) {
            return;
        }

        view.setImage(figure);

    }

    public void permit(boolean access) {

        Button button = (Button) root.lookup("#bottom").lookup("#done");

        button.setVisible(access);

    }

    public void inform(Integer turn, String name) {

        Text turnText = (Text) root.lookup("#top").lookup("#turn");

        turnText.setText("TURN : " + turn);

        Text nameText = (Text) root.lookup("#top").lookup("#name");

        nameText.setText("PLAYER : " + name.toUpperCase());

    }

    public void declare(String name, String score, Runnable onFinished) {

        Text turnText = (Text) root.lookup("#top").lookup("#turn");

        turnText.setVisible(false);
        turnText.setManaged(false);

        Region spaceRegion = (Region) root.lookup("#top").lookup("#space");

        spaceRegion.setVisible(false);
        spaceRegion.setManaged(false);

        Text nameText = (Text) root.lookup("#top").lookup("#name");

        if (name != null && score != null) {
            nameText.setText("WINNER : " + name.toUpperCase() + " - SCORE : " + score + " POINTS");
        } else {
            nameText.setText("DRAW MATCH");
        }

        Animation.pause(5, () -> {

            turnText.setVisible(true);
            turnText.setManaged(true);

            turnText.setText("");

            spaceRegion.setVisible(true);
            spaceRegion.setManaged(true);

            nameText.setText("");

            if (onFinished != null) {
                onFinished.run();
            }

        });

    }

}

