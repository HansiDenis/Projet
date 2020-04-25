package events;

/**
 * Classe représentant les évènements de type Nourriture et boisson
 */
public class FoodAndDrink extends Event {

    String kind; //le type, ie si c'est un restaurant, un bar, etc
    String cuisine;

    /**
     * Constructeur
     *
     * @param start jour de début
     * @param end   jour de fin
     * @param place lieu
     * @param name  intitulé de l'évènement
     * @param genre type d'évènement Food&Drink
     */
    public FoodAndDrink(int start, int end, String place, String name, String genre, String cui) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "f&d";
        this.kind = genre;
        this.cuisine = cui;
        AllEvents.getInstance().addEvent(this);
    }

    /**
     * Méthode d'affichage de l'évènement
     */
    @Override
    public void present() {
        super.present();
        System.out.println("Venez vous régaler avec nous dans notre " + this.kind + " et profiter de notre cuisine " + this.cuisine + ".");

    }

    /**
     * Méthode construisant la référence d'accès de l'évènement dans la HashMap hashAll
     *
     * @return la référence de l'évènement
     */
    @Override
    public String reference() {
        if (kind.length() <= 2) {
            return "FDE-" + this.kind + eventNumber + "-" + this.start + "-" + this.end;
        }
        return "FDE-" + this.kind.substring(0, 2) + eventNumber + "-" + this.start + "-" + this.end;
    }

    /**
     * Méthode disant si l'évènement à un type ou non
     *
     * @return false car l'évènement à effectivement un type("f&d")
     */
    public boolean hasNoType() {
        return false;
    }
}
