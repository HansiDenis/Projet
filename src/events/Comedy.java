package events;

/**
 * Classe représentant les évènements de type comédie
 */
public class Comedy extends Event {

    String ComedyType;
    double runTime;
    int note;

    /**
     * Constructeur d'un évènement de type comédie et ajout de celui-ci à la HashMap hashAll
     *
     * @param start      jour de début
     * @param end        jour de fin
     * @param place      lieu
     * @param name       intitulé de l'évènement
     * @param ComedyType type de comédie
     */
    public Comedy(int start, int end, String place, String name, String ComedyType, double runiTime) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "comedy";
        this.ComedyType = ComedyType;
        if (ComedyType.equals("one-man show")) {
            this.note = 18;
        }
        this.runTime = runiTime;
        AllEvents.getInstance().addEvent(this);
    }

    /**
     * Méthode d'affihage de l'évènement
     */
    @Override
    public void present() {
        super.present();
        System.out.println("La comédie est là pour vous faire rire et vous changez les idées.\n"
                + "Durée du spectacle: " + this.runTime * 60 + " minutes");
        if (ComedyType.equals("one-man show")) {
            System.out.println("C'est un one-man show si vous le souhaitez, vous pouvez mettre une note sur tripadvisor.\n"
                    + "La note actuelle est de" + this.note + " sur notre barême.");
        }
    }


    /**
     * Méthode construisant la référence d'accès de l'évènement dans la HashMap hashAll
     *
     * @return la référence de l'évènement
     */
    @Override
    public String reference() {
        return "SC" + ComedyType.substring(0, Integer.min(3, ComedyType.length())) + eventNumber + "-" + this.start + "-" + this.end;
    }

    /**
     * Méthode disant si l'évènement à un type ou non
     *
     * @return false car l'évènement à effectivement un type("comedy")
     */
    public boolean hasNoType() {
        return false;
    }
}

