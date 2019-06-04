package AntonioAguirre;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Client {

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile("DDBB/BDRemota.db4o");

        try {
            Vaixell[] vaixells = {
                    new Vaixell(1, "v1", 4),
                    new Vaixell(2, "v2", 5),
                    new Vaixell(3, "v3", 6)

            };

            TipusVaixell[] tipusVaixells= {
                    new TipusVaixell(1, "corbeta"),
                    new TipusVaixell(2, "fragata"),
                    new TipusVaixell(3, "destructor"),
                    new TipusVaixell(4, "creuer"),
                    new TipusVaixell(5, "portaavions")

            };


            vaixells[1].addArmament(new Armament("arm1"));
            vaixells[2].addArmament(new Armament("arm2"));
            vaixells[1].addArmament(new Armament("arm3"));


            for(int i = 0; i < vaixells.length; i++) {
                db.store(vaixells[i]);
            }
        } finally {
            db.close();
        }
    }

}
