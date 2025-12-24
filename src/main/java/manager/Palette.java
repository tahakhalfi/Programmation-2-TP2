package manager;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Palette {

    public static final Color COLOR_TRANSPARENT = Color.TRANSPARENT;
    public static final Color COLOR_WHITE = Color.rgb(255, 255, 255);
    public static final Color COLOR_CLAIRE = Color.rgb(255, 240, 200);
    public static final Color COLOR_PEACH = Color.rgb(255, 220, 135);
    public static final Color COLOR_ORANGE = Color.rgb(255, 185, 0);

    public static final Font FONT_NORMAL = Font.font("Franklin Gothic Demi", 18);
    public static final Font FONT_SMALLER = Font.font(FONT_NORMAL.getName(),16);
    public static final Font FONT_BIGGER = Font.font(FONT_NORMAL.getName(),20);
    public static final Font FONT_EXTREME = Font.font(FONT_NORMAL.getName(),30);

    public static Color colorBackground() {
        return COLOR_PEACH;
    }

    public static Color colorTerritory() {
        return COLOR_CLAIRE;
    }

    public static Color colorTitle() {
        return COLOR_ORANGE;
    }

    public static Color colorComment() {
        return COLOR_WHITE;
    }

    public static Color colorInvisible() {
        return COLOR_TRANSPARENT;
    }

    public static Color colorInactive() {
        return COLOR_WHITE;
    }

    public static Color colorActive() {
        return COLOR_CLAIRE;
    }

    public static Font fontTitle() {
        return FONT_EXTREME;
    }

    public static Font fontComment() {
        return FONT_NORMAL;
    }

    public static Font fontInactive() {
        return FONT_NORMAL;
    }

    public static Font fontActive() {
        return FONT_BIGGER;
    }

}
