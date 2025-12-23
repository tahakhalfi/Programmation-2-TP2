package controller;

import viewer.Window;
import viewer.interaction.Track;

public class Remote {

    public static void playButtonClicked() {
        Window.advance("config", null);
    }

    public static void bundleButtonClicked() {

    }

    public static void trackButtonClicked() {
        Window.advance("track", null);
    }

    public static void optionsButtonClicked() {

    }

    public static void quitButtonClicked() {
        Window.close(null);
    }

    public static void backButtonClicked(){
        Window.advance("menu",null);
    }

    public static void refreshButtonCliqued(){
        //Window.advance("track",null);
    }

    public static void clearHistoryButtonCliqued(){
        Track track = (Track) Window.getChapter("track");
        track.clearInfo();
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

