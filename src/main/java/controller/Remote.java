package controller;

import modeler.game.Mechanism;
import modeler.usage.Account;
import viewer.Window;
import viewer.interaction.Config;
import viewer.interaction.Track;

public class Remote {

    public static void playButtonClicked() {
        Window.advance("config", null);
    }

    public static void profileButtonClicked() {
        Window.advance("profile", null);
    }

    public static void trackButtonClicked() {
        Window.advance("track", null);
    }

    public static void quitButtonClicked() {

        Account.savein();

        Window.close(null);

    }

    public static void decreaseButtonClicked() {

        Config config = (Config) Window.getPage("config");

        config.indicate(Mechanism.extract());

    }

    public static void increaseButtonClicked() {

        Config config = (Config) Window.getPage("config");

        config.indicate(Mechanism.insert());

    }

    public static void backConfigButtonClicked() {

        Config config = (Config) Window.getPage("config");

        config.indicate(Mechanism.normalize());

        Window.advance("menu",null);

    }

    public static void startButtonClicked() {

        Mechanism.start();

        Window.advance("game", null);

    }

    public static void selectionButtonClicked(int index) {

        Mechanism.select(index);

    }

    public static void doneButtonClicked() {

    }

    public static void backTrackButtonClicked(){
        Window.advance("menu",null);
    }

    public static void refreshButtonCliqued(){
        //Window.advance("track",null);
    }

    public static void clearHistoryButtonCliqued(){
        Track track = (Track) Window.getPage("track");
        track.clearInfo();
    }

    // ajout

    public static void backProfileButtonClicked(){
        Window.advance("menu",null);
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

