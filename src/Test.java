import java.util.Scanner;

public class Test {

    public static void main(String[] args) {


        Client c = new Client("Maltese", "Salomé", "10/03/2000", "salome.maltes@gmail.com", "0619310708", "+33", 4);
        /**Hotel h = new Hotel();
         h.reservation(1, c, 1, "double");
         h.ticket(c);
         h.affichage();
         //Casino casino = new Casino(c);
         //casino.create();
         //casino.miser("pair", 20);
         //doySystem.out.println(casino.getGainpl());


         Hotel h = new Hotel();
         h.reservation(1, c, 1, "double");
         h.ticket(c);
         **/
        Hotel h = crHotel();
        Reception(h);
        h.affichage();
        Spa(h);

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
        System.out.println("Parfait! votre hôtel de 40 chambres est prêt .");
        return h;
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
        String res[] = {max, type};
        return res;
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
                    if (Character.toString(supplement.charAt(0)).equals("o")) {
                        entree = true;
                    } else {
                        entree = false;
                    }
                    if (Character.toString(supplement.charAt(2)).equals("o")) {
                        accompagnement = true;
                    } else {
                        accompagnement = false;
                    }
                    if (Character.toString(supplement.charAt(4)).equals("o")) {
                        dessert = true;
                    } else {
                        dessert = false;
                    }
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
                    if (Character.toString(supplement2.charAt(0)).equals("o")) {
                        entree = true;
                    } else {
                        entree = false;
                    }
                    if (Character.toString(supplement2.charAt(2)).equals("o")) {
                        dessert = true;
                    } else {
                        dessert = false;
                    }
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
            if (Character.toString(carte.charAt(0)).equals("o")) {
                entree = true;
            } else {
                entree = false;
            }
            if (Character.toString(carte.charAt(2)).equals("o")) {
                plat = true;
            } else {
                plat = false;
            }
            if (Character.toString(carte.charAt(4)).equals("o")) {
                accompagnement = true;
            } else {
                accompagnement = false;
            }
            if (Character.toString(carte.charAt(6)).equals("o")) {
                dessert = true;
            } else {
                dessert = false;
            }
            if (Character.toString(carte.charAt(8)).equals("o")) {
                boisson = true;
            } else {
                boisson = false;
            }
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
            com.afficheCommande();
        } else {
            c.setNote(note + prix);
            com.afficheCommande();
        }

    }

    private static void Restau(Hotel h) {
        Client[] c = h.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné")) {
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
            if (!i.getNom().equals("non renseigné")) {
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
}