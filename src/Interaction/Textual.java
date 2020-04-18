package Interaction;

public class Textual {
    String city;

    Textual(String cit) {
        this.city = cit;
    }

    void start() {
        System.out.println("Bienvenue sur la plateforme de recherche d'évènements de la ville de "
                + this.city + ".");
        System.out.println();
    }
}
