package events;

/**
 * Classe  représentant les Séries NBA,confrontations en 4 matchs gagnants entre deux
 * de NBA(Association américaine de basketball)
 */
public class NBASeries extends SportEvent {
    String team1;
    String team2;
    int seats;

    /**
     * Constructeur
     *
     * @param name   intitulé de l'évènement
     * @param place  lieu
     * @param start  jour de début
     * @param end    jour de fin
     * @param team1  équipe 1
     * @param team2  équipe 2
     * @param places nombre de places pour les matches(nombre limité)
     */
    public NBASeries(String name, String place, int start, int end, String team1, String team2, int places) {
        super(name, place, start, end, "basketball", false, 0);
        this.team1 = team1;
        this.team2 = team2;
        this.seats = places;
        AllEvents.getInstance().addEvent(this);
    }

    /**
     * Méthode d'affichage de l'évènement
     */
    public void present() {

        super.present();
        System.out.println("Finales NBA opposant les " + team1 + " et les "
                + team2 + ", la tension sera très ressentie pour les " + this.seats + " spectateurs,qui sera couronné champion NBA?");
    }

    /**
     * Méthode construisant la référence d'accès de l'évènement dans la HashMap hashAll
     *
     * @return la référence de l'évènement
     */
    public String reference() {
        return super.reference() + "-NBA-" + team1.substring(0, 1) + team2.substring(0, 1);
    }

}
