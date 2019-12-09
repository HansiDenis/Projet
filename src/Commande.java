public class Commande {

    boolean[] commande = new boolean[5];
    private double prix;

    public Commande() {
        this.prix = 0.0;
    }

    public boolean[] getCommande() {
        return commande;
    }

    public double getPrix() {
        return prix;
    }

    public void commandeFormule(String rep) {
        if (rep.equals("Mojito")) {
            prix = 6.0;
            commande[1] = true;
            commande[4] = true;
        } else if (rep.equals("Daiquiri")) {
            prix = 6.0;
            commande[1] = true;
            commande[2] = true;
            commande[4] = true;
        }

    }

    public double commandeCarte(boolean entrée, boolean plat, boolean accompagnement, boolean dessert, boolean boisson) {
        if (entrée) {
            commande[0] = entrée;
            prix += 3.0;
        } else if (plat) {
            commande[1] = plat;
            prix += 5.0;
        } else if (accompagnement) {
            commande[2] = accompagnement;
            prix += 2.0;
        } else if (dessert) {
            commande[3] = dessert;
            prix += 3.5;
        } else if (boisson) {
            commande[4] = boisson;
            prix += 2.0;
        }
        return prix;
    }

    public double addMojito(boolean entrée, boolean accompagnement, boolean dessert) {
        if (entrée) {
            commande[0] = entrée;
            prix += 3.0;
        } else if (accompagnement) {
            commande[2] = accompagnement;
            prix += 2.0;
        } else if (dessert) {
            commande[3] = dessert;
            prix += 3.5;
        }
        return prix;
    }

    public double addDaiquiri(boolean entrée, boolean dessert) {
        if (entrée) {
            commande[0] = entrée;
            prix += 3.0;
        } else if (dessert) {
            commande[3] = dessert;
            prix += 3.5;
        }
        return prix;
    }

    public void useTickets(int nb) {
        prix = prix - nb * 5;
    }

    public void afficheCommande() {
        System.out.println("Prix total de la commande : " + this.prix + "€");
    }

}
