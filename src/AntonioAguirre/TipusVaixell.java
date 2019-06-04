package AntonioAguirre;

public class TipusVaixell {

    int id;
    String nom; //corbeta, fragata, destructor, creuer, portaavions

    public TipusVaixell(int id, String nom) {
        this.id = id;
        this.nom = nom;
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
}
