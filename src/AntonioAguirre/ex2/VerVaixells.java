package AntonioAguirre.ex2;

import AntonioAguirre.Vaixell;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import exemple.Client;

public class VerVaixells {

        public static void verVaixells() {
            ObjectContainer db = Db4oEmbedded.openFile("DDBB/BDRemota.db4o");

            try {
                Predicate p = new Predicate<Vaixell>() {
                    @Override
                    public boolean match(Vaixell c) {
                        return true;
                    }
                };

                ObjectSet<Vaixell> result = db.query(p);

                while (result.hasNext()) {
                    Vaixell vaixell = result.next();
                    System.out.println("Barco: " + vaixell);
                }
            } finally {
                db.close();
                System.out.println("verBarcos(): FINAL");
                System.out.println("--------");
            }
        }

    public static void main(String[] args) {
        verVaixells();
    }
    }
