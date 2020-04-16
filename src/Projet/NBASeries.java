package Projet;

class NBASeries extends SportEvent {
    String[] teams;
    int places;

    NBASeries(String name, String place, int start, int end, String team1, String team2, int places) {
        super(name, place, start, end, "basketball");
        teams = new String[2];
        teams[0] = team1;
        teams[1] = team2;
        this.places = places;
    }

    void takePlace() {

        super.takePlace();
        System.out.println("Vous avez la chance d'assister à la s&rie où s'opposent les" + teams[0] + "et les"
                + teams[1] + ", la tension est palpable,qui sera couronné champion NBA?");
    }

    String reference() {
        return super.reference() + "NBA" + teams[0].substring(0, 1) + teams[1].substring(0, 1);
    }
}
