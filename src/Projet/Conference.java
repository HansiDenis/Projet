package Projet;

public class Conference extends Event {

    public String theme;

    Conference(int start, int end, String place, String name, String th) {
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "Conference";
        this.theme = th;
    }

    @Override
    void takePlace() {
        System.out.println("");
    }


    @Override
    public String reference() {
        if (theme.length() <= 2) {
            return "CE-" + this.theme;
        }
        return "CE-" + this.theme.substring(0, 2);
    }
}