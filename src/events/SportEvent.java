package events;

public class SportEvent extends Event {
    String sport;
    static int NUMBER_OF_EVENTS = 0;

    public SportEvent(String name, String place, int start, int end, String sport, boolean make) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.name = name;
        this.place = place;
        this.start = start;
        this.end = end;
        this.sport = sport;
        this.type = "sport";
        if (make) {
            AllEvents.getInstance().addEvent(this);
        }
    }

    @Override
    void takePlace() {
        System.out.println("En" + this.sport + ",l'important c'est la concentration et vous prenez plaisir à voir ces athlètes pratiquer au plus haut niveau.");
    }

    @Override
    public String reference() {
        return "SE-" + sport.substring(0, Integer.min(3, sport.length())) + eventNumber + "-" + this.start + "-" + this.end;
    }
}

