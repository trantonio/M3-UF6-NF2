package AntonioAguirre;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Vaixell {
    int id;
    String nom;
    int tipusID;
    List<Armament> lArmament = new LinkedList<Armament>();


    public Vaixell(int id, String nom, int tipusID) {
        this.id = id;
        this.nom = nom;
        setTipusID(tipusID);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTipusID() {
        return tipusID;
    }

    public void setTipusID(int tipusID) {
        this.tipusID = tipusID;

    }

    public void addArmament(Armament armament){
        lArmament.add(armament);
    }
    @Override
    public String toString() {
        String res = id + " : " + nom+ " : " + tipusID+ ", ";
        Iterator<Armament> it = lArmament.iterator();
        while (it.hasNext()) {
            Armament e = it.next();
            res += e.toString() + "\n";
        }
        return res;
    }
}
