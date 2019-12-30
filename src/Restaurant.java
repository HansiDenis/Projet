public class Restaurant {

    private static String carte = "Plat : 5€\nAccompagnement : 2€\nEntrée : 3€\nDessert : 3.50€\nBoisson : 2€\n\nFormules :\n\"Mojito\" : plat + boisson pour 6€\n" +
            "\"Daiquiri\"" + " : plat + accompagnement + boisson pour 8€";

    public Restaurant() {


    }

    public void afficheCarte() {
        System.out.println(carte);
    }
}
