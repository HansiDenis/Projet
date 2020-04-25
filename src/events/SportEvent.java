package events;
/**
 * Authors:MALTESE Salomé et DENIS Hansi
 **/
/**
 * Classe représentant les évènements sportifs en général
 */
public class SportEvent extends Event {
    String sport;
    int cashPrize = 0;

    /**
     * Conctructeur
     *
     * @param name   intitulé de l'évènement
     * @param place  lieu
     * @param start  jour de début
     * @param end    jour de fin
     * @param sport  sport pratiqué
     * @param make   si on doit ajouter l'évènement tel quel à hashAll,doit etre false si on
     *               veut créer un NBASeries
     * @param reward cahsprize si c'est une compétition avec de l'argent à la clé
     */
    public SportEvent(String name, String place, int start, int end, String sport, boolean make, int reward) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.name = name;
        this.place = place;
        this.start = start;
        this.end = end;
        this.sport = sport;
        this.type = "sport";
        if (reward != 0) {
            this.cashPrize = reward;
        }
        if (make) {
            AllEvents.getInstance().addEvent(this);
        }
    }

    /**
     * Méthode d'affichage de l'évènement
     */
    @Override
    public void present() {
        super.present();
        System.out.println("Sport concerné: " + this.sport);
        System.out.println("En " + this.sport + ",l'important c'est la concentration et vous prendrez plaisir à voir ces athlètes pratiquer au plus haut niveau.");
        if (cashPrize != 0) {
            System.out.println("Les participants se disputeront " + this.cashPrize + " euros.");
        }
    }

    /**
     * Méthode construisant la référence d'accès de l'évènement dans la HashMap hashAll
     *
     * @return la référence de l'évènement
     */
    @Override
    public String reference() {
        return "SE-" + sport.substring(0, Integer.min(3, sport.length())) + eventNumber + "-" + this.start + "-" + this.end;
    }

    /**
     * Méthode disant si l'évènement à un type ou non
     *
     * @return false car l'évènement à effectivement un type("sport")
     */
    public boolean hasNoType() {
        return false;
    }
}

