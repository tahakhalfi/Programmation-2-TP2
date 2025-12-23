package manager;

import javafx.scene.paint.Color;

public class Palette {

    public static final Color WHITE = Color.rgb(255, 255, 255);
    public static final Color CLAIRE = Color.rgb(255, 240, 200);
    public static final Color PEACH = Color.rgb(255, 220, 135);
    public static final Color ORANGE = Color.rgb(255, 185, 0);

    public static Color forBackground() {
        return PEACH;
    }

    public static Color forTitle() {
        return ORANGE;
    }

    public static Color forInactive() {
        return WHITE;
    }

    public static Color forActive() {
        return CLAIRE;
    }

}
