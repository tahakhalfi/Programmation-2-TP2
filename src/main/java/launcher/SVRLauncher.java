package launcher;

import modeler.usage.Account;

public class SVRLauncher {

    public static void launch(Class<SVRLauncher> ownClass, String[] args) {
        Account.enterin();
    }

}
