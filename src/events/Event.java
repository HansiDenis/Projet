package events;

/**
 * Classe abstraite servant de base pour la création via héritage d'évènements plus précis
 */
public abstract class Event {
    int start;
    int end;
    String place;
    String name;
    String type = "";
    static int NUMBER_OF_EVENTS = 0;
    int eventNumber;

    //GETTERS
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    String getDate() {
        if (this.start == this.end) {
            return " le " + this.start;
        }
        return "du " + start + " au " + end;
    }

    /**
     * Méthode disant si l'évènement à un type ou non
     *
     * @return true car l'évènement n'a pas de type
     */
    public boolean hasNoType() {
        return true;
    }

    /**
     * Base de l'affichage d'un évènement
     */
    public void present() {
        System.out.println("Nom de l'évènement: " + this.name + "\n"
                + "Date de l'évèment: " + getDate() + "\n"
                + "Lieu: " + this.place + "\n"
                + "Type de l'évènement: " + this.type);
    }

    /**
     * Méthode abstraite car on a besoin de plus d'informations pour créer une référence
     * pertinente, cette méthode est overridée dans les classes filles
     */
    public abstract String reference();
}
