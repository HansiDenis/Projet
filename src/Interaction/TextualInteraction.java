package Interaction;
/**
 * Authors:MALTESE Salomé et DENIS Hansi
 * <p>
 * Classe servant à l'interaction textuellle pour la recherche d'évènements
 * <p>
 * Classe servant à l'interaction textuellle pour la recherche d'évènements
 */

/**
 * Classe servant à l'interaction textuellle pour la recherche d'évènements
 */

import InterTree.Tree;
import events.AllEvents;
import events.Event;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class TextualInteraction {
    static ArrayList<String> types;
    String city;

    /**
     * Constructeur
     *
     * @param cite ville
     */
    public TextualInteraction(String cite) {
        types = new ArrayList<>();
        this.city = cite;
        types.add("sport");
        types.add("nba");
        types.add("comedy");
        types.add("conference");
        types.add("f&d");
        types.add("party");
        types.add("theatre");
    }

    /**
     * Méthode permettant d'effectuer le choix de la manière de rechercher
     *
     * @return un entier entre 1 et 4 correspondant à la matière de rechercher
     */
    int choose() {
        Scanner res = new Scanner(System.in);
        System.out.println("Voulez vous rechercher par :\n" +
                "-Type? (tapez 1)\n" +
                "-Par date?(tapez 2) \n" +
                "-Les deux?(tapez 3) \n"
                + "-Par référence?(tapez 4)");
        return res.nextInt();
    }

    /**
     * Méthode effectuant la recherche d'évènements
     *
     * @param i résultat de choose()
     * @param t arbre d'intervalle contenant les évènements au cas où on fait une recherche
     *          par date
     * @return found, la liste des évènements trouvés(éventuellement vide)
     */
    ArrayList<Event> search(int i, Tree t) {
        String m = "";
        ArrayList<Event> found = new ArrayList<>();
        while (!(m.equals("error1") | m.equals("error2") | m.equals("error3"))) {
            if (i == 1) {
                String type = byType();
                if (failTypeTest(type)) {
                    m = "error1";
                    break;
                }
                found = AllEvents.getInstance().typeSearch(type);
                success(found);
                break;
            }
            if (i == 2) {
                int[] date = byDate();
                int start = date[0];
                int end = date[1];
                if (dateFail(start, end)) {
                    m = "error2";
                    break;
                }
                found = AllEvents.getInstance().refSearch(t.dateSearch(start, end));
                success(found);
                break;
            }
            if (i == 3) {
                String[] set = byBoth();
                String type = set[0];
                int start = Integer.parseInt(set[1]);
                int end = Integer.parseInt(set[2]);
                if (!failTypeTest(type)) {
                    m = "error1";
                    break;
                }
                if (dateFail(start, end)) {
                    m = "error2";
                    break;
                }
                found.addAll(t.mixedSearch(start, end, type));
                success(found);
                break;
            }
            if (i == 4) {
                String ref = byRef();
                if (AllEvents.getInstance().refSearch(ref).hasNoType()) {
                    m = "error3";
                    break;
                }
                found.add(AllEvents.getInstance().refSearch(ref));
                success(found);
                break;
            }
        }
        failMessage(m);
        return found;
    }

    /**
     * méthode appelée après une recherche et donnant un feedback sur celle-ci
     *
     * @param events liste traitée
     */
    void success(ArrayList<Event> events) {
        if (events.isEmpty()) {
            System.out.println("Recherche peu fructueuse désolés.");
        } else {
            System.out.println("Votre recherche a été effectuée, voici les évènements trouvés:");
            display(events);
        }
    }

    /**
     * Affiche un message d'erreur personnalisé en fonction de l'erreur rencontrée s'il y
     * en a eu une
     *
     * @param errorType String décrivant le type d'erreur(type/date/référence)
     */
    void failMessage(String errorType) {
        if (errorType.equals("error1")) {
            System.out.println("Le type renseigné n'existe pas, nous vous conseillons de recommencer une recherche.");
        }
        if (errorType.equals("error2")) {
            System.out.println("Il y a eu un problème lors du renseignement de la date,nous vous conseillons de recommencer.");
        }
        if (errorType.equals("error3")) {
            System.out.println("Mauvaise référence renseignée.");
        }
    }

    /**
     * Récupère le type d'évènements recherché si on fait une recherche par type
     *
     * @return le type
     */
    String byType() {
        Scanner res = new Scanner(System.in);
        System.out.println("Quel type d'évènements voulez voir :\n" +
                "-Sportifs (tapez \"sport\")\n" + "-Séries NBA (tapez \"nba\")\n"
                + "-Comédies (tapez \"comedy\")\n" + "-Conférences (tapez \"conference\")\n"
                + "-Boisson et Nourriture (tapez \"f&d\")\n" + "-Fêtes (tapez \"party\")\n"
                + "-Pièces de Théâtre (tapez \"theatre\")");
        return res.nextLine();
    }

    /**
     * Test si le type souhaité existe
     *
     * @param type le type renseigné
     * @return true si le type n'existe pas false s'il existe
     */
    boolean failTypeTest(String type) {
        return !types.contains(type);
    }

    /**
     * Récupère la date pour une recherche par date
     *
     * @return la date sous form de tableau de deux entiers
     */
    int[] byDate() {
        Scanner res = new Scanner(System.in);
        System.out.println("Veuillez entrer la date de début de la recherche entre 1 et 366");
        int start = res.nextInt();
        Scanner res2 = new Scanner(System.in);
        System.out.println("Veuillez entrer la date de fin de la recherche entre 1 et 366 et > à celle de début");
        int end = res2.nextInt();
        return new int[]{start, end};
    }

    /**
     * Teste la validité de la date renseignée
     *
     * @param start jour de début
     * @param end   jour de fin
     * @return true si la date est non conforme false si elle l'est
     */
    boolean dateFail(int start, int end) {
        return (((start | end) <= 0) | ((start | end) > 366) | start > end);
    }

    /**
     * Récupère les informations nécessaires à la recherche croisée
     *
     * @return les informations sous forme de tableau de String
     */
    String[] byBoth() {
        int[] date = byDate();
        return new String[]{byType(), "" + date[0], "" + date[1]};
    }

    /**
     * Récupère la référence pour une recherche par référence
     *
     * @return référence renseignée
     */
    String byRef() {
        Scanner res = new Scanner(System.in);
        System.out.println("Veuillez entrer la référence de l'évènement souhaité.");
        return res.nextLine();
    }

    /**
     * Affichage textuel d'une liste d'évènements
     *
     * @param events liste dont on veut faire l'affichage
     */
    void display(ArrayList<Event> events) {
        for (Event event : events) {
            event.present();
            System.out.println("\n");
        }
    }

    /**
     * Sortie de l'interaction textuelle,propose un dernier affichage des évènements trouvés
     *
     * @param events list d'évènements trouvés
     */
    void exit(ArrayList<Event> events) {
        Scanner res = new Scanner(System.in);
        System.out.println("Voulez-vous voir l'affichage de tout vos évènements?\n"
                + "Tapez \"non\" si vous ne souhaitez pas l'affichage, il sera effectué dans tout autre cas.");
        if (!res.nextLine().equals("non")) {
            display(events);
        }

        System.out.println("Merci d'avoir utilisé notre système de recherche.");
    }

    /**
     * Totalité de l'interaction
     *
     * @param t Arbre d'intervalles conntenant les noeuds correspondant aux évènements
     */
    public void run(Tree t) {
        System.out.println("Bienvenue sur le système de recherche d'évènements de " + this.city);
        ArrayList<Event> found = new ArrayList<>();
        boolean ok = true;
        while (ok) {
            found = search(choose(), t);
            if (found.isEmpty()) {
                emptyMessage();
            }
            if (redo().equals("non")) {
                ok = false;
            }
        }
        found = add(t, found);
        exit(found);

    }

    /**
     * Ajout d'évènements à notre liste de résultats via d'autres recherches
     *
     * @param t      Arbre d'intervalle
     * @param events événements déjà trouvés
     * @return liste à laquelle on a ajouté(ou non) des évènements
     */
    ArrayList<Event> add(Tree t, ArrayList<Event> events) {
        ArrayList<Event> found;
        Scanner sc = new Scanner(System.in);
        System.out.println("Souhaitez-vous ajouter de nouveaux évènements à votre liste via d'autres recherches?(Tapez \"oui\" si oui)");
        String res = sc.nextLine();
        while (res.equals("oui")) {
            found = search(choose(), t);
            events.addAll(found);
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Souhaitez-vous continuer d'ajouter de nouveaux évènements à votre liste?(Tapez \"oui\" si oui)");
            res = sc2.nextLine();
        }
        LinkedHashSet<Event> hashSet = new LinkedHashSet<>(events);
        events = new ArrayList<>(hashSet);
        return events;
    }

    /**
     * Sert à savoir si on veut refaire une recherche
     *
     * @return la réponse de l'utilisateur
     */
    String redo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Souhaitez-vous effectuer une nouvelle recherche?(tapez \"oui\" ou \"non\")");
        return sc.nextLine();
    }

    /**
     * Affiche le message correspondant à n recherche qui ne renvoie pas de résultat
     */
    void emptyMessage() {
        System.out.println("Il semble que le résultat de votre recherche est vide, nous vous conseillons de réessayer.");
    }

    /**
     * Méthode créant les évènements puis lançant l'interaction textuelle
     */
    public void main() {
        run(AllEvents.createBaseEvents());
    }
}
