package manager;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.util.Duration;

import java.util.List;

public class Animation {

    public static void fadein(List<Node> list, int index, int step, double lapse, double delay, Runnable onFinished) {
        fade(list, index, step, 0, 1, lapse, delay, onFinished);
    }

    public static void fadein(Node element, double lapse, Runnable onFinished) {
        fade(element, 0, 1, lapse, onFinished);
    }

    public static void fadeout(List<Node> list, int index, int step, double lapse, double delay, Runnable onFinished) {
        fade(list, index, step, 1, 0, lapse, delay, onFinished);
    }

    public static void fadeout(Node element, double lapse, Runnable onFinished) {
        fade(element, 1, 0, lapse, onFinished);
    }

    public static void fade(List<Node> list, int index, int step, double start, double end, double lapse, double delay, Runnable onFinished) {

        if (index <= -1 || index >= list.size()) {
            return;
        }

        Node element = list.get(index);

        FadeTransition transition = new FadeTransition(Duration.seconds(lapse), element);
        transition.setFromValue(start);
        transition.setToValue(end);

        int next = index + step;

        if (-1 < next && next < list.size()) {

            pause(delay, () -> {
                fade(list, next, step, start, end, lapse, delay, onFinished);
            });

        } else {

            transition.setOnFinished(event -> {
                if (onFinished != null) {
                    onFinished.run();
                }
            });

        }

        transition.play();

    }

    public static void fade(Node element, double start, double end, double lapse, Runnable onFinished) {

        FadeTransition transition = new FadeTransition(Duration.seconds(lapse), element);
        transition.setFromValue(start);
        transition.setToValue(end);

        transition.setOnFinished(event -> {

            if (onFinished != null) {
                onFinished.run();
            }

        });

        transition.play();

    }

    public static void pause(double delay, Runnable onFinished) {

        PauseTransition pause = new PauseTransition(Duration.seconds(delay));

        pause.setOnFinished((event) -> {

            if (onFinished != null) {
                onFinished.run();
            }

        });

        pause.play();

    }

}

