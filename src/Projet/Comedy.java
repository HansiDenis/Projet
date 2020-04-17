package Projet;

public class Comedy extends Event {

    String comedy;
    int duree;
    int note;

    Comedy(int start, int end, String place, String name, String comedy, int note) {
        this.start = start;
        this.end = end;
        this.place = place;
        this.name = name;
        this.type = "Comedy";
        this.comedy = comedy;
        if (comedy.equals("one-man show")) {
            this.note = note;
        }
        this.duree = duree;
    }

    @Override
    void takePlace() {

        System.out.println("La comédie est là pour vous faire rire et vous changez les idées.");
        if (comedy.equals("one-man show")) {
            System.out.println("si vous le souhaiter, vous pouvez mettre une note sur tripadvisor.");
        }
    }

    @Override
    String reference() {
        return "SC" + comedy.substring(0, Integer.min(3, comedy.length()));
    }
}

