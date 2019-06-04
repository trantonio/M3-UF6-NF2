package AntonioAguirre.ex3;

import AntonioAguirre.Vaixell;
import AntonioAguirre.ex2.VerVaixells;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import exemple.Client;

import java.util.Scanner;

public class modVaixells {
    private static void ModTipus() {
        ObjectContainer db = Db4oEmbedded.openFile("DDBB/BDRemota.db4o");
        Scanner in = new Scanner(System.in);
        System.out.print("ModificaTipus(): Quin és nom del vaixell? ");
        String nom = in.nextLine();

        Vaixell qbe = new Vaixell(0, nom, 0);
        ObjectSet<Vaixell> vaixells = db.queryByExample(qbe);

        if (vaixells.size() != 1) {
            System.out.println("No es pot modificar aquest nom. N'hi ha més d'1 o 0.");
        } else {
            System.out.print("Quina és el nou tipus? ");
            int ad = in.nextInt();

            Vaixell c = vaixells.next();
            c.setTipusID(ad);
            db.store(c);
        }
        db.close();
        System.out.println("ModificaTipus(): FINAL");
        System.out.println("--------");
    }



    public static void main(String[] args) {
        VerVaixells.verVaixells();
        ModTipus();
        VerVaixells.verVaixells();
    }
}
