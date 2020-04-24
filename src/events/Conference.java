package events;
/**
 * Classe représentant les évènements de type conférence
 */
public class Conference extends Event {

    String theme;
    int ticketPrice = 0;

    /**
     * Constructeur d'un évènement de type conférence et ajout de celui-ci à la HashMap hashAll
     * @param start jour de début
     * @param end jour de fin
     * @param place lieu
     * @param name intitulé de l'évènement
     * @param th thème de la conférence
     * @param paid caractère payant ou non de l'entrée
     */
    Conference(int start, int end, String place, String name, String th, boolean paid) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "conference";
        this.theme = th;
        if (paid) {
            this.ticketPrice = 5;
        }
        AllEvents.getInstance().addEvent(this);
    }

    /**
     * Méthode d'affichage de l'évènement
     */
    @Override
    public void present() {
        super.present();
        System.out.println("Une conférence très enrichissante (Thème: " + this.theme + ").");
        if (this.ticketPrice != 0) {
            System.out.println("Prix du ticket: " + this.ticketPrice + " euros");
        }
    }

    /**
     *Méthode construisant la référence d'accès de l'évènement dans la HashMap hashAll
     * @return la référence de l'évènement
     */
    @Override
    public String reference() {
        if (theme.length() <= 2) {
            return "CE-" + this.theme + eventNumber + "-" + this.start + "-" + this.end;
        }
        return "CE-" + this.theme.substring(0, 2) + eventNumber + "-" + this.start + "-" + this.end;
    }
    /**
     *Méthode disant si l'évènement à un type ou non
     * @return false car l'évènement à effectivement un type("conference")
     */
    public boolean hasNoType(){
        return false;
    }
}