package controller;

import manager.Audio;
import modeler.game.Mechanism;
import modeler.game.Player;
import modeler.memory.History;
import modeler.usage.Account;
import viewer.Window;
import viewer.interaction.Config;
import viewer.interaction.Game;
import viewer.interaction.Profile;
import viewer.interaction.Track;

public class Remote {

    public static void playButtonClicked() {

        Window.advance("config", null);

    }

    public static void profileButtonClicked() {

        Profile profile = (Profile) Window.getPage("profile");

        profile.update();

        Window.advance("profile", null);

    }

    public static void trackButtonClicked() {

        Track track = (Track) Window.getPage("track");

        track.refresh(History.copy());

        Window.advance("track", null);

    }

    public static void clearButtonClicked() {

        Track track = (Track) Window.getPage("track");

        History.clear();

        track.refresh(History.copy());

    }

    public static void settingsButtonClicked() {

        Window.advance("settings",null);

    }

    public static void quitButtonClicked() {

        Account.savein();
        Window.close(null);

    }

    public static void backButtonClicked() {

        Window.advance("menu",null);

    }

    public static void decreaseButtonClicked() {

        Config config = (Config) Window.getPage("config");

        config.indicate(Mechanism.extract());

    }

    public static void increaseButtonClicked() {

        Config config = (Config) Window.getPage("config");

        config.indicate(Mechanism.insert());

    }

    public static void startButtonClicked() {

        Game game = (Game) Window.getPage("game");

        game.store(Mechanism.getQuantity());

        Window.advance("game", () -> {

            Mechanism.start();

            game.inform(Mechanism.getTurn(), Mechanism.getName());

            for (int i = 0; i < Mechanism.getQuantity(); i++) {

                Integer index = i;

                String section = Mechanism.getSection(index);
                Integer value = Mechanism.getValue(index);

                game.place(index, section);
                game.flicker(index, 10, () -> {game.present(index, value);});

            }

            game.permit(Mechanism.getAccess());

        });

    }

    public static void selectionButtonClicked(int index) {

        Game game = (Game) Window.getPage("game");

        Mechanism.select(index);

        game.place(index, Mechanism.getSection(index));

        game.permit(Mechanism.getAccess());

    }

    public static void doneButtonClicked() {

        Game game = (Game) Window.getPage("game");

        Track track = (Track) Window.getPage("track");

        Mechanism.transit();

        game.inform(Mechanism.getTurn(), Mechanism.getName());

        for (int i = 0; i < Mechanism.getQuantity(); i++) {

            Integer index = i;

            String section = Mechanism.getSection(index);
            Integer value = Mechanism.getValue(index);

            game.place(index, section);

            if (section.equals("in")) {game.flicker(index, 10, () -> {game.present(index, value);});}

        }

        game.permit(Mechanism.getAccess());

        if (!Mechanism.getActive()) {

            String name = null;
            String score = null;

            Player winner = Mechanism.getWinner();

            if (winner != null) {
                name = winner.getName();
                score = String.valueOf(winner.getScore());
            }

            History.save(name, score);

            game.declare(name, score, () -> {

                game.empty();

                Mechanism.end();

                game.inform(-1, "");

                for (int index = 0; index < Mechanism.getQuantity(); index++) {

                    game.place(index, null);
                    game.present(index, null);

                }

                game.permit(false);

                Window.advance("menu", null);

            });

        }

    }

}