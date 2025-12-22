package manager;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class Chronologue {

    public static void freeze(double seconds) {

        long milliseconds = (long) (1000 * seconds);

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
