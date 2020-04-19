package events;

public class Conference extends Event {

    String theme;
    int ticketPrice = 0;

    Conference(int start, int end, String place, String name, String th, boolean paid) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "conference";
        this.theme = th;
        if (paid) {
            this.ticketPrice = 5;
        }
        AllEvents.getInstance().addEvent(this);
    }

    @Override
    public void present() {
        super.present();
        System.out.println("Une conférence très enrichissante (Thème: " + this.theme + ").");
        if (this.ticketPrice != 0) {
            System.out.println("Prix du ticket: " + this.ticketPrice + " euros");
        }
    }


    @Override
    public String reference() {
        if (theme.length() <= 2) {
            return "CE-" + this.theme;
        }
        return "CE-" + this.theme.substring(0, 2);
    }
}