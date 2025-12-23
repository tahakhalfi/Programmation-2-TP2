package reviewer;

import manager.Message;
import manager.Storage;
import modeler.Machine;

import java.util.List;

public class MachineTest {

    public static void main(String[] args) {

        try {

            Machine.saveInfo(
                    "Nizar le Nul",
                    "0"
            );

            List<String> ligne = Machine.loadInfo(0);

            Message.state("// Ligne lue : " + ligne);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

