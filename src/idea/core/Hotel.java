package idea.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Classe représentant un hôtel composé de chambres, de clients et d'un restaurant
 * Représentation des chambres et des clients avec des tableaux
 *
 * @author MalteseDenis
 */

public class Hotel {

    private static int[] numChambre;
    private Client[] client;
    private Chambre[] chambres;
    private int nbSimple;
    private int nbDouble;
    private int nbTriple;
    private int nbDeluxe;
    private Restaurant resto;

    public int getNbDouble() {
        return nbDouble;
    }

    public int getNbTriple() {
        return nbTriple;
    }

    public int getNbDeluxe() {
        return nbDeluxe;
    }

    public int getNbSimple() {
        return nbSimple;
    }


    private String[] disponibilite;

    //Test validite nb total = 100

    //**************************************************************************************************************
    //CONSTRUCTORS
    //**************************************************************************************************************

    /**
     * @param nbSimple nombre de chambre simple dans l'hôtel
     * @param nbDouble nombre de chambre double dans l'hôtel
     * @param nbTriple nombre de chambre triple dans l'hôtel
     * @param nbDeluxe nombre de chambre deluxe dans l'hôtel
     * @fn création d'un hôtel de 40 chambres au total ainsi que son restaurant
     * Construction d'un tableau de chambres en fonction des paramètres
     * Création d'un tableau de 40 clients, initialisé au client par défaut
     * Création d'un tableau de disponibilité de taille 40, initialisé à "libre"
     * Création d'un tableau de numéros de chambre, allant de 1 à 40, pour vérifier facilement si une chamnbre est libre ou non
     */

    public Hotel(int nbSimple, int nbDouble, int nbTriple, int nbDeluxe) {
        this.nbSimple = nbSimple;
        this.nbDouble = nbDouble;
        this.nbTriple = nbTriple;
        this.nbDeluxe = nbDeluxe;
        chambres = new Chambre[nbSimple + nbDouble + nbTriple + nbDeluxe];
        disponibilite = new String[nbSimple + nbDouble + nbTriple + nbDeluxe];
        client = new Client[nbSimple + nbDouble + nbTriple + nbDeluxe];
        numChambre = new int[nbSimple + nbDouble + nbTriple + nbDeluxe];
        for (int i = 0; i < nbSimple; i++) {
            this.chambres[i] = new Chambre("simple");
        }
        for (int i = 0; i < nbDouble; i++) {
            this.chambres[nbSimple + i] = new Chambre("double");
        }
        for (int i = 0; i < nbTriple; i++) {
            this.chambres[nbSimple + nbDouble + i] = new Chambre("triple");
        }
        for (int i = 0; i < nbDeluxe; i++) {
            this.chambres[nbSimple + nbDouble + nbTriple + i] = new Chambre("deluxe");
        }

        for (int i = 0; i < nbSimple + nbDouble + nbTriple + nbDeluxe; i++) {
            disponibilite[i] = "libre";
            numChambre[i] = i + 1;
            client[i] = new Client();

        }
        this.resto = new Restaurant();
    }
    //*****************************************************************************************************************
    //PUBLIC METHODS

    //*****************************************************************************************************************
    //GETTERS

    /**
     * @return le restaurant de l'hotel
     */
    public Restaurant getResto() {
        return resto;
    }

    /**
     * @return le tableau des clients de l'hôtel
     */
    public Client[] getClient() {
        return client;
    }

    /**
     * @param client Client
     * @fn remplace le tableau de client courant par celui en paramètre
     */
    public void setClient(Client[] client) {
        this.client = client;
    }

    //*****************************************************************************************************************
    //SETTERS

    /**
     * @return le tableau des chambres de l'hôtel
     */
    public Chambre[] getChambres() {
        return chambres;
    }

    //*****************************************************************************************************************
    //OTHERS

    /**
     * @param num numéro de chambre
     * @fn modifie la chambre numéro @b num qui devient libre
     * @fn remplace le client numéro @b num par un client par défaut (équivalent à pas de client)
     */
    public void videchambre(int num) {
        this.disponibilite[num] = "libre";
        this.client[num] = new Client();
    }


    //grand while avec c=[3 1] puis c=max(type)

    /**
     * @param type type de chambre
     * @return un tableau de deux entiers
     * @fn le premier élément du tableau correspond au nombre de personnes maximum possible dans une chambre
     * @fn le second permet de s'assurer que le type de chambre renseigné est correct (1 pour correct, 0 sinon)
     */
    public int[] max(String type) {
        //while(b){
        //System.out.println("Quel type de chambre voulez-vous réserver ?(simple/double/triple/deluxe)");
        switch (type) {
            case "simple":
                return new int[]{1, 1};
            case "double":
            case "deluxe":
                return new int[]{2, 1};
            case "triple":
                return new int[]{3, 1};
            default:
                System.out.println("Mauvais type de chambre renseigné");
                return new int[]{0, 0};
        }
    }

    /**
     * @fn affichage des numéros de chambres ainsi que leur type et leur disponibilité
     * @fn affichage du nom du client si la chambre est occupée, "non renseigné" sinon
     */
    public void affichage() {
        for (int i = 0; i < 40; i++) {
            String c;
            if (client[i] == null) {
                c = "aucun";
            } else {
                c = client[i].getNom();
            }
            System.out.println(numChambre[i] + "               " + chambres[i].getType() + "               " + disponibilite[i] + "               " + c);
        }
    }

    /**
     * @param max  maximum de personnes possibles dans une chambre
     * @param c    client réservant une chambre
     * @param n    nombre de personnes pour qui le client réserve
     * @param type type de chambre
     * @return un entier (0 si la réservation ne peut pas se faire, 2 sinon)
     * @fn vérification que le type de chambre demandé est disponible et que le nombre de personnes voulant l'occuper est approprié
     * Par exemple 2 personnes dans une chambre simple n'est pas autorisé
     * @fn attribue un numéro de chambre au client si la réservation est possible. La chambre devient occupée
     */
    public int reservation(int max, Client c, int n, String type) { //n: nombre de personnes qu'a dit le client
        //Scanner sc = new Scanner(System.in);

        //System.out.println("Combien de personnes occuperont la chambre?");
        //int n = sc.nextInt();
        if (n > max) {
            System.out.println("Vous ne pouvez pas être autant que ça dans cette chambre, veuillez réaliser une nouvelle réservation.");
            return 0;
        } else if (this.disponibilite(type) == -1) {
            System.out.println("Le type de chambre que vous souhaitez n'est pas disponible");
            return 0;
        } else {
            int numChambre = this.disponibilite(type);
            disponibilite[numChambre - 1] = "occupée";
            client[numChambre - 1] = c;
            return 2;
        }
    }

    /**
     * @param type type de chambre
     * @return le numéro de chambre disponible, 0 si il n'y en pas
     * @fn vérifie qu'il a une chambre de type @b type disponible
     */
    public int disponibilite(String type) {
        int b = 0;
        switch (type) {
            case "simple":
                for (int i = 0; i < nbSimple; i++) {
                    b = i;
                    if (disponibilite[i].equals("libre")) {
                        break;
                    }
                    if (disponibilite[nbSimple - 1].equals("occupée")) {
                        return -1;
                    }
                }
                break;
            case "double":
                for (int i = nbSimple; i < nbSimple + nbDouble; i++) {
                    b = i;
                    if (disponibilite[i].equals("libre")) {
                        break;
                    }
                    if (disponibilite[nbSimple + nbDouble - 1].equals("occupée")) {
                        return -1;
                    }

                }
                break;
            case "triple":
                for (int i = nbSimple + nbDouble; i < nbSimple + nbDouble + nbTriple; i++) {
                    b = i;
                    if (disponibilite[i].equals("libre")) {
                        break;
                    }
                    if (disponibilite[nbSimple + nbDouble + nbTriple - 1].equals("occupée")) {
                        return -1;
                    }
                }
                break;
            case "deluxe":
                for (int i = nbSimple + nbDouble + nbTriple; i < 40; i++) {
                    b = i;
                    if (disponibilite[i].equals("libre")) {
                        break;
                    }
                    if (disponibilite[nbSimple + nbDouble + nbTriple + nbDeluxe].equals("occupée")) {
                        return -1;
                    }

                }
                break;
            default:
                b = -1;
                break;
        }
        return b + 1;
    }

    /**
     * @param c Client
     * @fn créée un ticket pour le client
     */
    public void ticket(Client c) {
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("d MMMM yyyy, H:m:s");
        System.out.println("**********HOTEL BLUE BAY CARACAO**********\n\nDate de réservation : " + formater.format(date) + "\n");
        c.affichage();
        int numChambre;
        int i = 0;
        while (client[i] != c && i <= 38) {
            i += 1;
        }
        numChambre = i + 1;
        String type = chambres[i].getType();
        System.out.println("Chambre n°: " + numChambre + "       Type de chambre : " + type);
    }


    /**
     * @param c Client voulant effectuer une réservation
     * @fn effectue la réservation si elle est possible selon les demandes du client
     * @fn affiche le ticket du client
     */
    public void Reservation(Client c) {
        Scanner sc = new Scanner(System.in);
        String[] tab = this.choixType();
        int max = Integer.parseInt(tab[0]);
        String type = tab[1];
        System.out.println("Les chambres simples acceuillent au maximum 1 pers,les chambres doubles et deluxes 2 "
                + "et les triples 3");
        System.out.println("Combien de personnes occuperont la chambre?");
        int n = sc.nextInt();
        while (this.reservation(max, c, n, type) == 0) {
            tab = this.choixType();
            max = Integer.parseInt(tab[0]);
            type = tab[1];
            System.out.println("Combien de personnes occuperont la chambre?");
            n = sc.nextInt();
        }
        System.out.println("Votre réservation est faite.");
        this.ticket(c);
    }

    /**
     * @fn Réception de l'hôtel. Enregistre des clients tant qu'il y en a
     */
    public void Reception() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Y-a-t-il un nouveau client ? (o/n)");
        String rep = sc.nextLine();
        while (rep.equals("o")) {
            Client c = Test.Enregistrement();
            this.Reservation(c);
            System.out.println("Y-a-t-il un nouveau client ? (o/n)");
            rep = sc.nextLine();
        }
    }

    /**
     * @return un tableau avec le @b type de chambre que le client veut ainsi que @b le max de personnes possibles dans cette chambre
     * La récupération du max est nécessaire pour l'utilisation de @b choixType dans @b reservation
     * @fn détermine quel type de chambre le client veut
     * @fn Réeffectue l'opération tant que le type ne correpond pas au nombre de personnes (chambre simple pour deux par exemple)
     */
    public String[] choixType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel type de chambre voulez-vous réserver ? (simple/double/triple/deluxe)");
        String type = sc.nextLine();
        int[] tab = this.max(type);

        while (tab[1] == 0) {
            System.out.println("Quel type de chambre voulez-vous réserver ? (simple/double/triple/deluxe)");
            type = sc.nextLine();
            tab = this.max(type);
        }
        String max = tab[0] + "";
        return new String[]{max, type};
    }

    public void Casino() {
        Client[] c = this.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue devant le  casino " + i.getNom());
                System.out.println("Voulez-vous entrer dans le casino ? (o/n)");
                String rep = sc.nextLine();
                if (rep.equals("o")) {
                    i.partie();
                }

            }
        }
    }

    /**
     * @fn Propose au client un baptême de plongée ou une croisière
     */
    public void Plongee() {
        Client[] c = this.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue au site de plongée " + i.getNom());
                System.out.println("Voulez-vous faire un baptême de plongée ou une croisière ? (o/n)");
                String rep = sc.nextLine();
                if (rep.equals("o")) {
                    i.plong();
                }

            }
        }
    }

    /**
     * @fn Détermine combien
     */
    public void wifi() {
        Client[] c = this.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue au site de règlement de l'utilisation d'Internet " + i.getNom());
                System.out.println("Avez-vous utilisé Internet aujourd'hui ? (o/n)");
                String rep = sc.nextLine();
                if (rep.equals("o")) {
                    i.CoInt();
                }

            }
        }
    }


    public void Restau() {
        Client[] c = this.getClient();
        Restaurant r = this.getResto();
        System.out.println("Le restaurant ouvre ses portes, voici sa carte : \n\n");
        r.afficheCarte();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue au restaurant " + i.getNom());
                System.out.println("Voulez-vous commander quelque chose ? (o/n)");
                String rep = sc.nextLine();
                while (rep.equals("o")) {
                    i.commandeRestau();
                    System.out.println("Voulez-vous commander autre chose ? (o/n)");
                    rep = sc.nextLine();
                }

            }
        }
    }

    public void Spa() {
        Client[] c = this.getClient();
        for (Client i : c) {
            if (!i.getNom().equals("non renseigné") && i.getPresence()) {
                double tot = 0;
                Scanner sc = new Scanner(System.in);
                System.out.println("Bienvenue au Spa " + i.getNom());
                System.out.println("Voulez-vous un massage ? (o/n)");
                String rep = sc.nextLine();
                while (rep.equals("o")) {
                    tot += i.Massage();
                    System.out.println("Voulez-vous autre massage ? (o/n)");
                    rep = sc.nextLine();
                }
                System.out.println("Coût total : " + tot + " euros");
            }
        }
    }

    public void payrooms() {
        Chambre[] rooms = this.getChambres();
        Client[] c = this.getClient();
        for (int i = 0; i < 40; i++) {
            if (!c[i].getNom().equals("non renseigné")) {
                c[i].setNote(c[i].getNote() + rooms[i].Prix());
                System.out.println("La note de M(me) " + c[i].getNom() + " a été incrémentée de "
                        + rooms[i].Prix() + " pour la location de sa chambre");
            }
        }

    }


    public void day() {
        this.Reception();
        System.out.println("\n");
        this.payrooms();
        System.out.println("\n");
        this.Spa();
        System.out.println("\n");
        this.Restau();
        System.out.println("\n");
        this.Plongee();
        System.out.println("\n");
        this.Casino();
        System.out.println("\n");
        this.wifi();
        System.out.println("\n");
        Client[] c = this.getClient();
        for (Client i : c) {
            if (!i.getPresence()) {
                i.setAbroad(i.getAbroad() + 1);
            }
        }
    }
}
