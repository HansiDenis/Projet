package events;

public class Theatre extends Event {

    public String mainActor;
    public int nbPlaces;
    String title;
    String genre;

    Theatre(int start, int end, String place, String name, String actor, int nb, String g) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "Theatre";
        this.mainActor = actor;
        this.nbPlaces = nb;
        this.genre = g;
        AllEvents.getInstance().addEvent(this);
    }

    @Override
    void takePlace() {
        System.out.println("");
    }


    @Override
    public String reference() {
        if (title.length() <= 2) {
            return "TE-" + title;
        }
        return "TE-" + title.substring(0, 2);
    }
}