package manager;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.event.EventHandler;

public class Chronologue {

    public static String date() {

        LocalDate today = LocalDate.now();

        int day = today.getDayOfMonth();
        int month = today.getMonthValue();
        int year = today.getYear();

        LocalTime moment = LocalTime.now();

        int hour = moment.getHour();
        int minute = moment.getMinute();
        int second = moment.getSecond();

        return day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second;

    }

    public static void pause(double time) {

        long milliseconds = (long) (1000 * time);

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void hang(double time, EventHandler handler) {

        PauseTransition pause = new PauseTransition(Duration.seconds(time));
        pause.setOnFinished(handler);
        pause.play();

    }

}
