package events;

public class FoodAndDrink extends Event {

    public String kind; //le type, ie si c'est un restaurant, un bar, etc

    FoodAndDrink(int start, int end, String place, String name, String genre) {
        NUMBER_OF_EVENTS += 1;
        this.eventNumber = NUMBER_OF_EVENTS;
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "f&d";
        this.kind = genre;
        AllEvents.getInstance().addEvent(this);
    }

    @Override
    public void present() {
        super.present();
        System.out.println("Venez vous régaler avec nous dans notre" + this.kind + ".");
    }


    @Override
    public String reference() {
        if (kind.length() <= 2) {
            return "FDE-" + this.kind;
        }
        return "FDE-" + this.kind.substring(0, 2);
    }
}
