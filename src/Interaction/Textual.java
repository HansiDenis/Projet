package Interaction;

public class Textual {
    String city;

    Textual(String cite) {
        this.city = cite;
    }

    void start() {
        System.out.println("Bienvenue sur la plateforme de recherche d'évènements de la ville de "
                + this.city + ".");
        System.out.println();
    }
}
