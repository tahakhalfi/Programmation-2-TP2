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

import java.util.*;

public class Game extends Page {

    private static final ArrayList<Image> FIGURES = new ArrayList<>(Arrays.asList(
            new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice1.png"))),
            new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice2.png"))),
            new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice3.png"))),
            new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice4.png"))),
            new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice5.png"))),
            new Image(Objects.requireNonNull(Game.class.getResourceAsStream("/images/dice6.png")))
    ));

    private ArrayList<Button> selections;
    private HashMap<String, String> trajectories;

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
        turn.setText("TURN #1");
        turn.setFill(Palette.colorComment());
        turn.setFont(Palette.fontComment());

        top.getChildren().add(turn);

        // SPACE REGION

        space = new Region();
        HBox.setHgrow(space, Priority.ALWAYS);

        top.getChildren().add(space);

        // CONTROL TEXT

        Text control = new Text();
        control.setId("control");
        control.setText("NONAME");
        control.setFill(Palette.colorComment());
        control.setFont(Palette.fontComment());

        top.getChildren().add(control);

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
        territory.setMinSize(100, 600);
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

        for (int i = 0; i < 6; i++) {

            Image figure = FIGURES.get(i);

            ImageView selection = new ImageView(figure);
            selection.setFitWidth(50);
            selection.setFitHeight(50);
            selection.setPreserveRatio(true);
            selection.setSmooth(true);

            button = new Button();
            button.setGraphic(selection);
            button.setBackground(new Background(new BackgroundFill(Palette.colorInvisible(), null, null)));

            int index = i;

            button.setOnMouseClicked(event -> {Remote.selectionButtonClicked(index);});

            selections.add(button);

        }

        trajectories = new HashMap<>();

        trajectories.put("in", "trans");
        trajectories.put("trans", "in");

        super.setRoot(root);

    }

    public void open(Runnable onFinished) {

        Integer[] chosens = {1, 2, 3, 4, 5, 6};

        place("in", List.of(chosens));

        if (onFinished != null) {
            onFinished.run();
        }

    }

    public void close(Runnable onFinished) {

        Integer[] chosens = {1, 2, 3, 4, 5, 6};

        place("in", List.of(chosens));
        place("trans", List.of(chosens));
        place("out", List.of(chosens));

        if (onFinished != null) {
            onFinished.run();
        }

    }

    public void place(String section, List<Integer> indexes) {

        Pane territory = (Pane) root.lookup("#middle").lookup("#" + section);

        if (territory == null) {
            return;
        }

        Pane area = (Pane) territory.lookup("#area");

        for (int i = 0; i < indexes.size(); i++) {

            int index = indexes.get(i) - 1;

            if (index < 0 || index > selections.size() - 1) {
                continue;
            }

            Button selection = selections.get(index);

            if (selection == null || selection.getParent() == area) {
                continue;
            }

            area.getChildren().add(selection);

        }

    }

    public void place(String section, int index) {

        Pane territory = (Pane) root.lookup("#middle").lookup("#" + section);

        if (territory == null) {
            return;
        }

        Pane area = (Pane) territory.lookup("#area");

        if (index < 0 || index > selections.size() - 1) {
            return;
        }

        Button selection = selections.get(index);

        if (selection == null || selection.getParent() == area) {
            return;
        }

        area.getChildren().add(selection);

    }

    public void retrieve(String section, List<Integer> indexes) {

        Pane territory = (Pane) root.lookup("#middle").lookup("#" + section);

        if (territory == null) {
            return;
        }

        Pane area = (Pane) territory.lookup("#area");

        for (int i = 0; i < indexes.size(); i++) {

            int index = indexes.get(i) - 1;

            if (index < 0 || index > selections.size() - 1) {
                continue;
            }

            Button selection = selections.get(index);

            if (selection == null || selection.getParent() != area) {
                continue;
            }

            area.getChildren().remove(selection);

        }

    }

    public void retrieve(String section, int index) {

        Pane territory = (Pane) root.lookup("#middle").lookup("#" + section);

        if (territory == null) {
            return;
        }

        Pane area = (Pane) territory.lookup("#area");

        if (index < 0 || index > selections.size() - 1) {
            return;
        }

        Button selection = selections.get(index);

        if (selection == null || selection.getParent() != area) {
            return;
        }

        area.getChildren().remove(selection);

    }

}

