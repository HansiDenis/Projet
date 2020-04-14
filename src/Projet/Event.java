package Projet;

import java.util.List;

abstract class Event {
    int[] date;
    String place;
    String name;
    String type;

    int[] getDate() {
        return date;
    }

    String getPlace() {
        return place;
    }

    String getName() {
        return name;
    }

    String getType() {
        return type;
    }

    abstract void takePlace(List<Event> newEvents);

    abstract boolean attendable();

    abstract String reference();
}
