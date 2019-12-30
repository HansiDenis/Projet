public class ConnexionInternet {

    private int heures;
    private int prix;


    public ConnexionInternet(int h) {
        heures = h;
        prix = 10 * h;
    }

    public int getPrix() {
        return prix;
    }

}
