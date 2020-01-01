public class Commande {

    boolean[] commande = new boolean[5];
    private double prix;

    public Commande() {
        this.prix = 0.0;
    }

    public double commandeFormule(String rep) {
        if (rep.equals("mojito")) {
            prix = 6.0;
            commande[1] = true;
            commande[4] = true;
        } else if (rep.equals("daiquiri")) {
            prix = 8.0;
            commande[1] = true;
            commande[2] = true;
            commande[4] = true;
        }
        return prix;
    }

    public double commandeCarte(boolean entree, boolean plat, boolean accompagnement, boolean dessert, boolean boisson) {
        if (entree) {
            commande[0] = entree;
            prix += 3.0;
        }
        if (plat) {
            commande[1] = plat;
            prix += 5.0;
        }
        if (accompagnement) {
            commande[2] = accompagnement;
            prix += 2.0;
        }
        if (dessert) {
            commande[3] = dessert;
            prix += 3.5;
        }
        if (boisson) {
            commande[4] = boisson;
            prix += 2.0;
        }
        return prix;
    }

    public double addMojito(boolean entree, boolean accompagnement, boolean dessert) {
        if (entree) {
            commande[0] = entree;
            prix += 3.0;
        }
        if (accompagnement) {
            commande[2] = accompagnement;
            prix += 2.0;
        }
        if (dessert) {
            commande[3] = dessert;
            prix += 3.5;
        }
        return prix;
    }

    public double addDaiquiri(boolean entree, boolean dessert) {
        if (entree) {
            commande[0] = entree;
            prix += 3.0;
        }
        if (dessert) {
            commande[3] = dessert;
            prix += 3.5;
        }
        return prix;
    }

    public void useTicket() {
        if (prix > 5) {
            prix = prix - 5;
        } else {
            prix = 0;
        }
    }

    public void afficheCommande() {
        System.out.println("Prix total de la commande : " + this.prix + "€");
    }


}
