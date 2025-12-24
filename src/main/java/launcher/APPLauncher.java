package launcher;

import javafx.application.Application;

public class APPLauncher {

    public static void main(String[] args) {
        APPLauncher.launch(APPLauncher.class, args);
    }

    public static void launch(Class<APPLauncher> ownClass, String[] args) {
        SVRLauncher.launch(SVRLauncher.class, args);
        CLTLauncher.launch(CLTLauncher.class, args);
    }

}
