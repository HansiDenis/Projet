package idea.core;

public class Restaurant {

    public Restaurant() {


    }

    public void afficheCarte() {
        String carte = "Plat : 5€\nAccompagnement : 2€\nEntrée : 3€\nDessert : 3.50€\nBoisson : 2€\n\nFormules :\n\"Mojito\" : plat + boisson pour 6€\n" +
                "\"Daiquiri\"" + " : plat + accompagnement + boisson pour 8€";
        System.out.println(carte);
    }
}
