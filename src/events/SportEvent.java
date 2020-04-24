package events;

public class SportEvent extends Event {
    String sport;
    int cashPrize = 0;

    public SportEvent(String name, String place, int start, int end, String sport, boolean make, boolean reward) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.name = name;
        this.place = place;
        this.start = start;
        this.end = end;
        this.sport = sport;
        this.type = "sport";
        if (reward) {
            this.cashPrize = 100000;
        }
        if (make) {
            AllEvents.getInstance().addEvent(this);
        }
    }

    @Override
    public void present() {
        super.present();
        System.out.println("En " + this.sport + ",l'important c'est la concentration et vous prendrez plaisir à voir ces athlètes pratiquer au plus haut niveau.");
        if (cashPrize != 0) {
            System.out.println("Ils se disputeront " + this.cashPrize + " euros.");
        }
    }

    @Override
    public String reference() {
        return "SE-" + sport.substring(0, Integer.min(3, sport.length())) + eventNumber + "-" + this.start + "-" + this.end;
    }
}

