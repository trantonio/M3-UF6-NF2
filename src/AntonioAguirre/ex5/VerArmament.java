package AntonioAguirre.ex5;

import AntonioAguirre.Armament;
import AntonioAguirre.Vaixell;
import AntonioAguirre.ex2.VerVaixells;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;
import exemple.Client;
import exemple.Encarrec;

import java.util.Scanner;

public class VerArmament {
    static ObjectContainer db = Db4oEmbedded.openFile("DDBB/BDRemota.db4o");

        public static void verArmas() {


            try {
                Predicate p = new Predicate<Armament>() {
                    @Override
                    public boolean match(Armament c) {
                        return true;
                    }
                };

                ObjectSet<Armament> result = db.query(p);

                while (result.hasNext()) {
                    Armament armas = result.next();
                    System.out.println("Arma: " + armas);
                }
            } finally {
                db.close();
                System.out.println("verArmas(): FINAL");
                System.out.println("--------");
            }
        }

    private static void AfegirArmas() {
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Client.class).cascadeOnUpdate(true);
        ObjectContainer db = Db4oEmbedded.openFile(config, "DDBB/BDRemota.db4o");
        Scanner in = new Scanner(System.in);
        System.out.print("AfegirArma(): Quin és nom del Barco? ");
        final String nom = in.nextLine();

        Vaixell qbe = new Vaixell(0, nom, 0);
        ObjectSet<Vaixell> vaixells = db.queryByExample(qbe);
        try {
            Predicate p = new Predicate<Vaixell>() {
                @Override
                public boolean match(Vaixell c) {
                    return c.getNom().equalsIgnoreCase(nom);
                }
            };

            ObjectSet<Client> clients = db.query(p);

            if (clients.size() != 1) {
                System.out.println("No es pot modificar aquest nom. N'hi ha més d'1 o 0.");
            } else {


                Vaixell c = vaixells.next();

                try {
                    Predicate r = new Predicate<Armament>() {
                        @Override
                        public boolean match(Armament c) {
                            return true;
                        }
                    };

                    ObjectSet<Armament> result = db.query(r);

                    while (result.hasNext()) {
                        Armament armas = result.next();
                        System.out.println("-----------------------------" +armas);
                        System.out.println("-----------------------------" +c);
                        c.addArmament(new Armament(armas.getNom()));
                    }
                } finally {
                    System.out.println("verArmas(): FINAL");
                    System.out.println("--------");
                }
                db.store(c);
            }
        } finally {
            db.close();
            System.out.println("AfegirEncarrec(): FINAL");
            System.out.println("--------");
        }
    }
    public static void main(String[] args) {
        verArmas();
AfegirArmas();
        VerVaixells.verVaixells();

    }
}
