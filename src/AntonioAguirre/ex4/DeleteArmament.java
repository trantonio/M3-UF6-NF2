package AntonioAguirre.ex4;

import AntonioAguirre.ex2.VerVaixells;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import exemple.Client;

import java.util.List;
import java.util.Scanner;

public class DeleteArmament {
    private static void esborraArmament() {
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Client.class).cascadeOnDelete(true);
        ObjectContainer db = Db4oEmbedded.openFile(config, "DDBB/BDRemota.db4o");

        System.out.println("esborraTD(): INICI");

        Scanner in = new Scanner(System.in);
        System.out.print("ModificaTipus(): Quin és nom del vaixell? ");
        String nom = in.nextLine();
        List result = db.queryByExample(new Object());

        for (Object cli : result) {
            if(cli.equals(nom)) {
                System.out.println("Esborrant: " + cli);
            }
//            db.delete(cli);
        }

        db.close();
        System.out.println("esborraTotaLaBD(): FINAL");
        System.out.println("--------");
    }

    public static void main(String[] args) {
        VerVaixells.verVaixells();
        esborraArmament();
        VerVaixells.verVaixells();
    }
}
