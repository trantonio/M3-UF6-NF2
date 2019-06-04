package AntonioAguirre;

public class Armament {

    String nom;
    String tipus; //Misil, Torpedo, Cañon ...

    public Armament(String nom) {
        this.nom = nom;
        getTipus(nom);
    }

    public String getNom() {
        return nom;
    }

    public String getTipus(String nom) {
        switch (nom){
            case "arm1":
                return "Cañon";

            case "arm2":
                return "Misil";
            case "arm3":
                return "Torpedo";
            default:
                return "Nada";

        }
    }
    @Override
    public String toString() {
        return getNom()+ " − " + getTipus(getNom()) ;
    }
}
