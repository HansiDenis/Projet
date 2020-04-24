package events;

/**
 * Classe représentant les évènements de type comédie
 */
public class Comedy extends Event {

    String ComedyType;
    int runTime;
    int note;

    /**
     * Constructeur d'un évènement de type comédie et ajout de celui-ci à la HashMap hashAll
     * @param start jour de début
     * @param end jour de fin
     * @param place lieu
     * @param name intitulé de l'évènement
     * @param ComedyType type de comédie
     * @param runiTime durée
     * @param note note sur TripAdvisor s'il s'agit d'un one-man show
     */
    Comedy(int start, int end, String place, String name, String ComedyType, int runiTime, int note) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "comedy";
        this.ComedyType = ComedyType;
        if (ComedyType.equals("one-man show")) {
            this.note = note;
        }
        this.runTime = runiTime;
        AllEvents.getInstance().addEvent(this);
    }

    /**
     * Méthode d'affihage de l'évènement
     */
    @Override
    public void present() {

        System.out.println("La comédie est là pour vous faire rire et vous changez les idées.\n"
        +"Durée du spectacle: "+this.runTime +" heures");
        if (ComedyType.equals("one-man show")) {
            System.out.println("C'est un one-man show si vous le souhaitez, vous pouvez mettre une note sur tripadvisor.\n"
                    + "La note actuelle est de" + this.note + ".");
        }
    }


    /**
     * Méthode construisant la référence d'accès de l'évènement dans la HashMap hashAll
     * @return la référence de l'évènement
     */
    @Override
    public String reference() {
        return "SC" + ComedyType.substring(0, Integer.min(3, ComedyType.length())) + eventNumber + "-" + this.start + "-" + this.end;
    }

    /**
     *Méthode disant si l'évènement à un type ou non
     * @return false car l'évènement à effectivement un type("comedy")
     */
    public boolean hasNoType(){
        return false;
    }
}

