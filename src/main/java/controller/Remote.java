package controller;

import modeler.Machine;
import viewer.Window;
import viewer.classes.pages.Track;

public class Remote {

    private static final Machine machine = new Machine();

    public static void playButtonClicked() {
        Window.advance("place", null);
    }

    public static void bundleButtonClicked() {

    }

    public static void trackButtonClicked() {

        Track track = (Track) Window.getChapter("track");

        Window.advance("track", null);

    }

    public static void optionsButtonClicked() {

    }

    public static void backToMenuButtonCliqued(){
        Window.advance("menu",null);
    }

    public static void quitButtonClicked() {
        Window.close(null);
    }

}



/*package controller;

import viewer.Window;

public class Remote {


    public static void playButtonClicked() {
        Window.advance("place", null);
    }

    public static void bundleButtonClicked() {

    }

    public static void trackButtonClicked() {
        Window.advance("track", null);
    }

    public static void optionsButtonClicked() {

    }

    public static void quitButtonClicked() { Window.close(null); }



}
*/

