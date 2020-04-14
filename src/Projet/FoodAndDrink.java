package Projet;

import java.util.List;

public class FoodAndDrink extends Event {

    public String kind; //le type, ie si c'est un restaurant, un bar, etc

    FoodAndDrink(int[] date, String place, String name, String genre) {
        this.date = date;
        this.place = place;
        this.name = name;
        this.type = "Food&Drink";
        this.kind = genre;
    }

    void takePlace(List<Event> newEvents) {
        System.out.println("");
    }

    String reference() {
        if (kind.length() <= 2) {
            return "f&d" + this.kind;
        }
        return "f&d" + this.kind.substring(0, 2);
    }
}
