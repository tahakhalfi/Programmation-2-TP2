package modeler;

import java.util.List;

public class MachineTest {

    public static void main(String[] args) {

        try {
            Machine machine = new Machine();

            // TEST saveInfo
            int index = machine.saveInfo(
                    "Nizar le Boss",
                    "4 vs 5"
            );

            System.out.println("Ligne écrite à l'index : " + index);

            // TEST loadInfo
            List<String> ligne = machine.loadInfo(index);

            System.out.println("Ligne lue : " + ligne);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

