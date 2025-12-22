package manager;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.time.LocalDate;

public class Chronologue {

    public static String date() {

        LocalDate today = LocalDate.now();

        int day = today.getDayOfMonth();
        int month = today.getMonthValue();
        int year = today.getYear();

        String format = day + "/" + month + "/" + year;

        return format;

    }

    public static void pause(double seconds) {

        long milliseconds = (long) (1000 * seconds);

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
