package events;

public abstract class Event {
    int start;
    int end;
    String place;
    String name;
    String type;
    static int NUMBER_OF_EVENTS = 0;
    int eventNumber;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

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
