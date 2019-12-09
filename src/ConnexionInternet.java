public class ConnexionInternet {

    private int heures;
    private int prix;

    public ConnexionInternet() {
        this(0);
    }

    public ConnexionInternet(int h) {
        heures = h;
        prix = 10 * h;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void calculPrix(int h) {
        prix = prix + 10 * h;
    }

    public void affiche() {
        System.out.println("Connexion Internet : " + this.heures + "h\nCoût : " + this.prix + "€");
    }
}
