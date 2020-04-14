package Projet;

import java.util.List;

public class FoodAndDrink extends Event {

    public String kind; //le type, ie si c'est un restaurant, un bar, etc

    FoodAndDrink(int start, int end, String place, String name, String genre) {
        date = new int[2];
        this.date[0] = start;
        this.date[1] = end;
        this.place = place;
        this.name = name;
        this.type = "Food & Drink";
        this.kind = genre;
    }

    @Override
    void takePlace(List<Event> newEvents) {
        System.out.println("");
    }

    @Override
    String reference() {
        if (kind.length() <= 2) {
            return "efd" + this.kind;
        }
        return "efd" + this.kind.substring(0, 2);
    }
}
