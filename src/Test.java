import java.util.Scanner;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        Sejour();


    }

    private static Hotel crHotel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nous allons créer votre hôtel");
        System.out.println("Quelle est la répartition des types de chambres (simples/doubles/triples/deluxes)?Vous en avez 40 au total.");
        System.out.println("Combien simples?");
        int simple = sc.nextInt();
        System.out.println("Combien doubles?");
        int doubles = sc.nextInt();
        System.out.println("Combien triples?");
        int triple = sc.nextInt();
        System.out.println("Combien deluxes?");
        int deluxe = sc.nextInt();
        Hotel h = new Hotel(simple, doubles, triple, deluxe);
        while (h.getNbDeluxe() + h.getNbDouble() + h.getNbSimple() + h.getNbTriple() != 40) {
            System.out.println("Nombre de chambres total incorrect");
            h = crHotel();
        }
        if (h.getNbDeluxe() + h.getNbDouble() + h.getNbSimple() + h.getNbTriple() == 40) {
            System.out.println("Parfait! votre hôtel de 40 chambres est prêt .");
        }
        return h;
    }

    private static void tour(Casino cas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez vous miser?(rouge/noir/pair/impair/manque/passe) Il ya une mise surprise");
        String mise = sc.nextLine();
        if (!mise.equals("rouge") && !mise.equals("noir") && !mise.equals("pair") && !mise.equals("impair") && !mise.equals("manque") && !mise.equals("passe") && !mise.equals("zéro")) {
            System.out.println("Type de mise renseigné non reconnu veuillez recommencer svp");
            tour(cas);
            return;
        }
        System.out.println("Combien voulez vous miser?Mises entières uniquement");
        int valeur = sc.nextInt();
        cas.miser(mise, valeur);
        System.out.println("Résultats de ce tour:");
        System.out.println("Gain total:" + cas.getGainpl());
        System.out.println("Jetons restants:" + cas.getNbj());
    }

    private static void partie(Client c) {
        Casino cas = new Casino(c);
        cas.create();
        cas.setGainpl(c.getGains());
        cas.setNbj(c.getJetons());
        System.out.println("Nous vous proposons de jouer à la roulette cela vous intéresse t-il?(o/n)");
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        while (rep.equals("o")) {
            tour(cas);
            System.out.println("Voulez  vous rejouer?(o/n)");
            rep = sc.nextLine();
        }
        System.out.println("Gains totaux" + cas.getGainpl());
        System.out.println("Jetons" + cas.getNbj());
        c.setGains(cas.getGainpl());
        c.setJetons(cas.getNbj());
    }

    private static void Casino(Hotel h) {
        Client[] c = h.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue devant le  casino " + i.getNom());
                System.out.println("Voulez-vous entrer dans le casino ? (oui/non)");
                String rep = sc.nextLine();
                if (rep.equals("oui")) {
                    partie(i);
                }

            }
        }
    }

    private static void plong(Client c) {
        Scanner sc = new Scanner(System.in);
        int l;
        Plongee def = new Plongee();
            def.affichageTarifs();
            System.out.println("Combien de baptêmes souhaitez vous?");
            int n = sc.nextInt();
            if (c.getDuree() < 10) {
                System.out.println("Votre temps de séjour n'est pas assez long pour participer à la croisière");
                l = 0;
            } else {
                System.out.println("Combien de croisières voulez vous effectuer? Si vous en choisissez vous partirez sur le champ");
                l = sc.nextInt();
                if (l > 0) {
                    c.setPresence(false);
                }
            }
            Plongee p = new Plongee(n, l);
            //Rajouter tableau de présence à l'hôtel
            p.Prix();
            c.setNote(c.getNote() + p.total());

        System.out.println("Votre note de frais a bien été mise à jour");
    }

    private static void Plongee(Hotel h) {
        Client[] c = h.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue au site de plongée " + i.getNom());
                System.out.println("Voulez-vous faire un baptême de plongée ou une croisière ? (oui/non)");
                String rep = sc.nextLine();
                if (rep.equals("oui")) {
                    plong(i);
                }

            }
        }
    }

    private static void wifi(Hotel h) {
        Client[] c = h.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue au site de règlement de l'utilisation d'Internet " + i.getNom());
                System.out.println("Avez-vous utilisé Internet aujourd'hui ? (oui/non)");
                String rep = sc.nextLine();
                if (rep.equals("oui")) {
                    CoInt(i);
                }

            }
        }
    }

    private static void CoInt(Client c) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Combien d'heures avez vous passé sur internet aujourd'hui?");
        int t = sc.nextInt();
        ConnexionInternet co = new ConnexionInternet(t);
        System.out.println("La conexion internet est facturée 10euros de l'heure.Votre note de frais a été mise à jour.");
        double p = co.getPrix();
        c.setNote(c.getNote() + p);
    }


    private static Client Enregistrement() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est votre nom ? ");
        String nom = sc.nextLine();
        System.out.println("Quel est votre prénom ? ");
        String prenom = sc.nextLine();
        System.out.println("Quel est votre date de naissance ? (jj/mm/aaaa)");
        String birtday = sc.nextLine();
        System.out.println("Quel est votre adresse email ? ");
        String mail = sc.nextLine();
        System.out.println("Quel est votre numéro de téléphone ? ");
        String num = sc.nextLine();
        System.out.println("Quel est votre indice téléphonique ?");
        String indice = sc.nextLine();
        System.out.println("Quelle est la durée de votre séjour ? ");
        int duree = sc.nextInt();
        Client c = new Client(nom, prenom, birtday, mail, num, indice, duree);
        while (c.getEmail() == null || c.getNaissance() == null || c.getTel() == null) {
            System.out.println("Echec de la réception. Veuillez recommencez. ");
            c = Enregistrement();
        }
        return c;
    }

    private static String[] choixType(Hotel h) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel type de chambre voulez-vous réserver ? (simple/double/triple/deluxe)");
        String type = sc.nextLine();
        int[] tab = h.max(type);

        while (tab[1] == 0) {
            System.out.println("Quel type de chambre voulez-vous réserver ? (simple/double/triple/deluxe)");
            type = sc.nextLine();
            tab = h.max(type);
        }
        String max = tab[0] + "";
        return new String[]{max, type};
    }

    private static void Reservation(Hotel h, Client c) {
        Scanner sc = new Scanner(System.in);
        String[] tab = choixType(h);
        int max = Integer.parseInt(tab[0]);
        String type = tab[1];
        System.out.println("Combien de personnes occuperont la chambre?");
        int n = sc.nextInt();
        while (h.reservation(max, c, n, type) == 0) {
            tab = choixType(h);
            max = Integer.parseInt(tab[0]);
            type = tab[1];
            System.out.println("Combien de personnes occuperont la chambre?");
            n = sc.nextInt();
        }
        Chambre chambre = new Chambre(type);
        System.out.println("Votre réservation est faite.");
        h.ticket(c);
        c.setNote(chambre.Prix());
    }

    private static void Reception(Hotel h) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Y-a-t-il un nouveau client ? (oui/non)");
        String rep = sc.nextLine();
        while (rep.equals("oui")) {
            Client c = Enregistrement();
            Reservation(h, c);
            System.out.println("Y-a-t-il un nouveau client ? (oui/non)");
            rep = sc.nextLine();
        }
    }

    private static void commandeRestau(Client c) {
        boolean entree;
        boolean plat;
        boolean accompagnement;
        boolean dessert;
        boolean boisson;
        double prix;
        double note = c.getNote();
        Commande com = new Commande();
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez-vous une formule ou une commande à la carte ? (formule/carte) ");
        String rep = sc.nextLine();
        if (rep.equals("formule")) {
            System.out.println("Quelle formule avez-vous choisi ? (mojito/daiquiri)");
            String formule = sc.nextLine();
            if (formule.equals("mojito")) {
                prix = com.commandeFormule(formule);
                System.out.println("Voulez-vous autre chose ? (o/n) ");
                String rep2 = sc.nextLine();
                if (rep2.equals("o")) {
                    System.out.println("Voulez-vous une entrée ? Un accompagnement ? Un dessert ? (o/n o/n o/n)");
                    String supplement = sc.nextLine();
                    entree = Character.toString(supplement.charAt(0)).equals("o");
                    accompagnement = Character.toString(supplement.charAt(2)).equals("o");
                    dessert = Character.toString(supplement.charAt(4)).equals("o");
                    prix += com.addMojito(entree, accompagnement, dessert);
                    c.setNote(note + prix);
                    com.afficheCommande();
                } else {
                    com.afficheCommande();
                    c.setNote(note + prix);
                }
            } else {
                prix = com.commandeFormule(formule);
                System.out.println("Voulez-vous autre chose ? (o/n) ");
                String rep3 = sc.nextLine();
                if (rep3.equals("o")) {
                    System.out.println("Voulez-vous une entrée ? Un dessert ? (o/n o/n)");
                    String supplement2 = sc.nextLine();
                    entree = Character.toString(supplement2.charAt(0)).equals("o");
                    dessert = Character.toString(supplement2.charAt(2)).equals("o");
                    prix += com.addDaiquiri(entree, dessert);
                    c.setNote(note + prix);
                    com.afficheCommande();
                } else {
                    com.afficheCommande();
                    c.setNote(note + prix);
                }
            }
        } else if (rep.equals("carte")) {
            System.out.println("Voulez-vous une entrée ? Un plat ? Un accompagnement ? Un dessert ? Une boisson ? (o/n o/n o/n o/n o/n)");
            String carte = sc.nextLine();
            entree = Character.toString(carte.charAt(0)).equals("o");
            plat = Character.toString(carte.charAt(2)).equals("o");
            accompagnement = Character.toString(carte.charAt(4)).equals("o");
            dessert = Character.toString(carte.charAt(6)).equals("o");
            boisson = Character.toString(carte.charAt(8)).equals("o");
            prix = com.commandeCarte(entree, plat, accompagnement, dessert, boisson);
        } else {
            System.out.println("Nous n'avons pas compris votre commande. Veuillez recommencer s'il vous plait.");
            return;
        }

        System.out.println("Voulez-vous utiliser des tickets restaurants ? (o/n)");
        String re = sc.nextLine();
        if (re.equals("o") && c.getTickets() > 0) {
            com.useTicket();
            c.setNote(note + prix);
            c.setTickets();
            System.out.println("Votre note a été mise à jour. Votre nombre de tickets aussi. Il vous reste " + c.getTickets() + " tickets.");
        } else {
            c.setNote(note + prix);
        }
        com.afficheCommande();

    }

    private static void Restau(Hotel h) {
        Client[] c = h.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue au restaurant " + i.getNom());
                System.out.println("Voulez-vous commander quelque chose ? (oui/non)");
                String rep = sc.nextLine();
                while (rep.equals("oui")) {
                    commandeRestau(i);
                    System.out.println("Voulez-vous commander autre chose ? (oui/non)");
                    rep = sc.nextLine();
                }

            }
        }
    }

    private static double Massage(Client c) {
        Spa spa = new Spa();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel type de massage voulez-vous ? (relaxant/pierres/elixir) ");
        String type = sc.nextLine();
        double prix = spa.Prix(type);
        spa.affichePrix();
        c.setNote(c.getNote() + prix);
        return prix;
    }


    private static void Spa(Hotel h) {
        Client[] c = h.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                double tot = 0;
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue au Spa " + i.getNom());
                System.out.println("Voulez-vous un massage ? (oui/non)");
                String rep = sc.nextLine();
                while (rep.equals("oui")) {
                    tot += Massage(i);
                    System.out.println("Voulez-vous autre massage ? (oui/non)");
                    rep = sc.nextLine();
                }
                System.out.println("Coût total : " + tot + " euros");
            }
        }
    }

    private static void day(Hotel h) {
        Reception(h);
        Spa(h);
        Restau(h);
        Plongee(h);
        Casino(h);
        wifi(h);
        Client[] c = h.getClient();
        for (Client i : c) {
            if (!i.getPresence()) {
                i.setAbroad(i.getAbroad() + 1);
            }
        }
    }

    private static void Sejour() {
        Hotel h = crHotel();
        int max = 1;
        while (max > 0) {
            day(h);
            Client[] c = h.getClient();
            int[] durees = new int[c.length];
            for (int i = 0; i < 40; i++) {
                c[i].setDuree(c[i].getDuree() - 1);
                durees[i] = c[i].getDuree();
                if (c[i].getDuree() == 0) {
                    h.videchambre(i);
                }
            }
            h.setClient(c);
            max = IntStream.of(durees).max().getAsInt();
            h.affichage();
        }

    }
}