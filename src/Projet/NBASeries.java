package Projet;

class NBASeries extends SportEvent {
    String team1;
    String team2;
    int places;

    NBASeries(String name, String place, int start, int end, String team1, String team2, int places) {
        super(name, place, start, end, "basketball");
        this.team1 = team1;
        this.team2 = team2;
        this.places = places;
    }

    void takePlace() {

        super.takePlace();
        System.out.println("Vous avez la chance d'assister à la s&rie où s'opposent les" + team1 + "et les"
                + team2 + ", la tension est palpable,qui sera couronné champion NBA?");
    }

    String reference() {
        return super.reference() + "-NBA-" + team1.substring(0, 1) + team2.substring(0, 1);
    }
}
