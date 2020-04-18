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
        this.type = "Food & Drink";
        this.kind = genre;
        AllEvents.getInstance().addEvent(this);
    }

    @Override
    void takePlace() {
        System.out.println();
    }


    @Override
    public String reference() {
        if (kind.length() <= 2) {
            return "FDE-" + this.kind;
        }
        return "FDE-" + this.kind.substring(0, 2);
    }
}
