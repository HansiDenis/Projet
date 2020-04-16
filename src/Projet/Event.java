package Projet;

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

    abstract void takePlace();

    abstract String reference();
}
