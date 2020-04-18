package Projet;

public class Conference extends Event {

    public String theme;

    FoodAndDrink(int start, int end, String place, String name, String theme) {
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "Conference";
        this.theme = theme;
    }

    @Override
    void takePlace() {
        System.out.println("");
    }


    @Override
    String reference() {
        if (theme.length() <= 2) {
            return "CE-" + this.theme;
        }
        return "CE-" + this.theme.substring(0, 2);
    }
}