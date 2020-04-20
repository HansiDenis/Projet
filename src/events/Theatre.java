package events;

public class Theatre extends Event {

    public String leadActor;
    public int seats;
    String title;
    String genre;

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

    @Override
    public void present() {
        super.present();
        System.out.println("Acteur principal: " + this.leadActor + "\n"
                + "Nombre de places: " + this.seats + "\n"
                + "Genre: " + this.genre);
    }


    @Override
    public String reference() {
        if (title.length() <= 2) {
            return "TE-" + title + eventNumber + "-" + this.start + "-" + this.end;
        }
        return "TE-" + title.substring(0, 2) + eventNumber + "-" + this.start + "-" + this.end;
    }
}