package events;

/**
 * Classe représentant les évènements festifs
 */
public class Party extends Event {

    String kind; //genre pour carnaval ou anniversaire
    String theme;
    int age; //pour anniv

    /**
     * Constructeur
     *
     * @param start jour de début
     * @param end   jour de fin
     * @param place lieu
     * @param name  intitulé de l'évènement
     * @param kind  type(anniversaire/Carnaval ou autre)
     * @param th    thème de la fête
     * @param age   âge de la personne dont c'est l'anniversaire si s'en est un
     **/
    Party(int start, int end, String place, String name, String kind, String th, int age) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.theme = th;
        this.type = "party";
        this.kind = kind;
        if (kind.equals("anniversaire")) {
            this.age = age;
        }
        AllEvents.getInstance().addEvent(this);
    }

    /**
     * Méthode d'affihage de l'évènement
     */
    @Override
    public void present() {
        super.present();
        System.out.println("Venez avec nous célebrer ce(t)" + this.kind + ".\n"
                + "Le thème de la fête est " + this.theme + ".");
        if (this.kind.equals("anniversaire")) {
            System.out.println("On vous invite à célebrer ses " + this.age + " ans.");
        }
    }

    /**
     * Méthode construisant la référence d'accès de l'évènement dans la HashMap hashAll
     *
     * @return la référence de l'évènement
     */
    @Override
    public String reference() {
        if (name.length() <= 2) {
            return "PE-" + this.kind + eventNumber + "-" + this.start + "-" + this.end;
        }
        return "PE-" + this.kind.substring(0, 2) + eventNumber + "-" + this.start + "-" + this.end;
    }

    /**
     * Méthode disant si l'évènement à un type ou non
     *
     * @return false car l'évènement à effectivement un type("party")
     */
    public boolean hasNoType() {
        return false;
    }
}