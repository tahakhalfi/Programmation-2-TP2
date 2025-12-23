package manager;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

import java.util.List;

public class Animation {

    public static void fadein(List<Node> list, int index, Runnable onFinished) {
        fade(0, 1, list, index, onFinished);
    }

    public static void fadein(Node element, Runnable onFinished) {
        fade(0, 1, element, onFinished);
    }

    public static void fadeout(List<Node> list, int index, Runnable onFinished) {
        fade(1, 0, list, index, onFinished);
    }

    public static void fadeout(Node element, Runnable onFinished) {
        fade(1, 0, element, onFinished);
    }

    public static void fade(double start, double end, List<Node> list, int index, Runnable onFinished) {

        Node element = list.get(index);

        FadeTransition transition = new FadeTransition(Duration.seconds(1), element);
        transition.setFromValue(start);
        transition.setToValue(end);

        transition.setOnFinished(event -> {

            if (index < list.size() - 1) {
                fade(start, end, list, index + 1, onFinished);
            } else if (onFinished != null) {
                onFinished.run();
            }

        });

        transition.play();

    }

    public static void fade(double start, double end, Node element, Runnable onFinished) {

        FadeTransition transition = new FadeTransition(Duration.seconds(1), element);
        transition.setFromValue(start);
        transition.setToValue(end);

        transition.setOnFinished(event -> {

            if (onFinished != null) {
                onFinished.run();
            }

        });

        transition.play();

    }

}

