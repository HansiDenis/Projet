package Interaction;

import InterTree.Tree;
import events.AllEvents;
import events.Event;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class TextualInteraction {
    static ArrayList<String> types;
    String city;

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

    int choose() {
        Scanner res = new Scanner(System.in);
        System.out.println("Voulez vous rechercher par :\n" +
                "-Type? (tapez 1)\n" +
                "-Par date?(tapez 2) \n" +
                "-Les deux?(tapez 3) \n"
                + "-Par référence?(tapez 4)");
        return res.nextInt();
    }

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

    void success(ArrayList<Event> events) {
        System.out.println("Votre recherche a été effectuée, voici les évènements trouvés:");
        display(events);
    }

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

    String byType() {
        Scanner res = new Scanner(System.in);
        System.out.println("Quel type d'évènements voulez voir :\n" +
                "-Sportifs (tapez \"sport\")\n" + "-Séries NBA (tapez \"nba\")\n"
                + "-Comédies (tapez \"comedy\")\n" + "-Conférences (tapez \"conference\")\n"
                + "-Boisson et Nourriture (tapez \"f&d\")\n" + "-Fêtes (tapez \"party\")\n"
                + "-Pièces de Théâtre (tapez \"theatre\")");
        return res.nextLine();
    }

    boolean failTypeTest(String type) {
        return !types.contains(type);
    }

    int[] byDate() {
        Scanner res = new Scanner(System.in);
        System.out.println("Veuillez entrer la date de début de la recherche entre 0 et 366");
        int start = res.nextInt();
        Scanner res2 = new Scanner(System.in);
        System.out.println("Veuillez entrer la date de fin de la recherche entre 0 e;t 366 et > à celle de début");
        int end = res2.nextInt();
        return new int[]{start, end};
    }

    boolean dateFail(int start, int end) {
        return ((start | end) < 0) | ((start | end) > 366) | start > end;
    }

    String[] byBoth() {
        int[] date = byDate();
        return new String[]{byType(), "" + date[0], "" + date[1]};
    }

    String byRef() {
        Scanner res = new Scanner(System.in);
        System.out.println("Veuillez entrer la référence de l'évènement souhaité.");
        return res.nextLine();
    }

    void display(ArrayList<Event> events) {
        for (Event event : events) {
            event.present();
        }
    }

    void exit(ArrayList<Event> events) {
        String display = "yes";
        while (display.equals("yes")) {
            Scanner res = new Scanner(System.in);
            System.out.println("Voulez vous voir l'affichage de tout vos évènements?\n"
                    + "Tapez \"non\" si vous ne souhaitez pas l'affichage, il sera effectué dans tout autre cas");
            display = res.nextLine();
            display(events);
        }
        System.out.println("Merci d'avoir utilisé notre système de recherche.");
    }

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

    String redo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Souhaitez-vous effectuer une nouvelle recherche?(tapez \"oui\" ou \"non\")");
        return sc.nextLine();
    }

    void emptyMessage() {
        System.out.println("Il semble que le résultat de votre recherche est vide, nous vous conseillons de réessayer.");
    }
}
