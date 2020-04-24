package events;

public abstract class Event {
    int start;
    int end;
    String place;
    String name;
    String type = "";
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

    public boolean hasNoType() {
        return true;
    }

    public void present() {
        System.out.println("Nom de l'évènement: " + this.name + "\n"
                + "Date de l'évèment: " + getDate() + "\n"
                + "Lieu: " + this.type + "\n"
                + "Type de l'évènement: " + this.type);
    }

    public abstract String reference();
}
