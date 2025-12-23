package reviewer;

import manager.Message;
import manager.Storage;
import modeler.Machine;

import java.util.List;

public class MachineTest {

    public static void main(String[] args) {

        try {

            // TEST saveInfo
            Machine.saveInfo(
                    "Nizar le Nul",
                    "0"
            );

            // TEST loadInfo
            List<String> ligne = Machine.loadInfo(0);

            Message.state("// Ligne lue : " + ligne);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

