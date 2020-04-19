package events;

public class NBASeries extends SportEvent {
    String team1;
    String team2;
    int seats;

    public NBASeries(String name, String place, int start, int end, String team1, String team2, int places) {
        super(name, place, start, end, "basketball", false, false);
        this.team1 = team1;
        this.team2 = team2;
        this.seats = places;
        AllEvents.getInstance().addEvent(this);
    }

    public void present() {

        super.present();
        System.out.println("Finales NBA opposant les " + team1 + " et les "
                + team2 + ", la tension sera très ressentie pour les " + this.seats + " spectateurs,qui sera couronné champion NBA?");
    }

    public String reference() {
        return super.reference() + "-NBA-" + team1.substring(0, 1) + team2.substring(0, 1);
    }
}
