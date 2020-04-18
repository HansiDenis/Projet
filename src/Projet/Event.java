package Projet;

public abstract class Event {
    int start;
    int end;
    String place;
    String name;
    String type;

    String getDate() {
        return "du " + start + " au " + end;
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

    public abstract String reference();
}
