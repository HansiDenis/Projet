package events;

public class Comedy extends Event {

    String comedy;
    int duree;
    int note;

    Comedy(int start, int end, String place, String name, String comedy, int note) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "comedy";
        this.comedy = comedy;
        if (comedy.equals("one-man show")) {
            this.note = note;
        }
        this.duree = duree;
        AllEvents.getInstance().addEvent(this);
    }

    @Override
    public void present() {

        System.out.println("La comédie est là pour vous faire rire et vous changez les idées.");
        if (comedy.equals("one-man show")) {
            System.out.println("C'est un one-man show si vous le souhaitez, vous pouvez mettre une note sur tripadvisor.\n"
                    + "La note actuelle est de" + this.note + ".");
        }
    }

    @Override
    public String reference() {
        return "SC" + comedy.substring(0, Integer.min(3, comedy.length()));
    }
}

