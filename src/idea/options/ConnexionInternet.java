package idea.options;

/**
 * Classe représentant l'option wifi de l'hôtel
 *
 * @author MalteseDenis
 */


public class ConnexionInternet {

    private int prix;

    /**
     * Constructeur
     *
     * @param h nombre d'heures de wifi utilisé
     * @fn construit le prix en fonction du nombre d'heures
     */
    public ConnexionInternet(int h) {
        prix = 10 * h;
    }

    /**
     * @return coût de l'utilisation du wifi
     */
    public int getPrix() {
        return prix;
    }

}
