package manager;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Audio {

    private static final String CORE = "/sounds/";

    private static int volume = 100;

    public static void playClick() {
        play("click.wav");
    }

    public static void playPop() {
        play("pop.wav");
    }

    public static void playTap() {
        play("tap.wav");
    }

    public static void play(String name) {

        try {

            String path = CORE + name;

            InputStream is = Audio.class.getResourceAsStream(path);

            if (is == null) throw new RuntimeException("Sound not found");

            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(
                            new BufferedInputStream(is)
                    );

            Clip clip = AudioSystem.getClip();
            clip.open(audio);

            FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            float min = gain.getMinimum();
            float max = gain.getMaximum();

            float percentage = (float) volume / 100;
            float dB = min + (max - min) * percentage;

            gain.setValue(dB);

            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void setVolume(int givenVolume) {
        System.out.println(givenVolume);
        volume = givenVolume;
    }

}

