package events;

public class Conference extends Event {

    public String theme;

    Conference(int start, int end, String place, String name, String th) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "Conference";
        this.theme = th;
        AllEvents.getInstance().addEvent(this);
    }

    @Override
    void takePlace() {
        System.out.println();
    }


    @Override
    public String reference() {
        if (theme.length() <= 2) {
            return "CE-" + this.theme;
        }
        return "CE-" + this.theme.substring(0, 2);
    }
}