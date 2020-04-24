package events;

/**
 * Classe représentant les pièces de théâtre
 */
public class Theatre extends Event {

    public String leadActor;
    public int seats;
    String title;
    String genre;

    /**
     * Constructeur
     *
     * @param start jour de début
     * @param end   jour de fin
     * @param place lieu
     * @param name  intitulé de l'évènement
     * @param actor acteur principal
     * @param nb    nombre de places
     * @param g     genre de pièce(drame/historique)
     */
    Theatre(int start, int end, String place, String name, String actor, int nb, String g) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "theatre";
        this.leadActor = actor;
        this.seats = nb;
        this.genre = g;
        AllEvents.getInstance().addEvent(this);
    }

    /**
     * Méthode d'affichage de l'évènement
     */
    @Override
    public void present() {
        super.present();
        System.out.println("Acteur principal: " + this.leadActor + "\n"
                + "Nombre de places: " + this.seats + "\n"
                + "Genre: " + this.genre);
    }

    /**
     * Méthode construisant la référence d'accès de l'évènement dans la HashMap hashAll
     *
     * @return la référence de l'évènement
     */
    @Override
    public String reference() {
        if (title.length() <= 2) {
            return "TE-" + title + eventNumber + "-" + this.start + "-" + this.end;
        }
        return "TE-" + title.substring(0, 2) + eventNumber + "-" + this.start + "-" + this.end;
    }

    /**
     * Méthode disant si l'évènement à un type ou non
     *
     * @return false car l'évènement à effectivement un type("theatre")
     */
    public boolean hasNoType() {
        return false;
    }
}