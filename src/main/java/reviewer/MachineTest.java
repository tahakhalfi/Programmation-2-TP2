package reviewer;

import modeler.Machine;

import java.util.List;

public class MachineTest {

    public static void main(String[] args) {

        try {

            // TEST saveInfo
            int index = Machine.saveInfo(
                    "Nizar le Boss",
                    "4 vs 5"
            );

            System.out.println("Ligne écrite à l'index : " + index);

            // TEST loadInfo
            List<String> ligne = Machine.loadInfo(index);

            System.out.println("Ligne lue : " + ligne);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

