package idea.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Hotel {

    private static int[] numChambre;
    private Client[] client;
    private Chambre[] chambres;
    private int nbSimple;
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

    private int nbDouble;
    private int nbTriple;
    private int nbDeluxe;
    private String[] disponibilite;

    //Test validite nb total = 100
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

    public void videchambre(int num) {
        this.disponibilite[num] = "libre";
        this.client[num] = new Client();
    }

    public Restaurant getResto() {
        return resto;
    }

    //grand while avec c=[3 1] puis c=max(type)
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


    public Client[] getClient() {
        return client;
    }

    public Chambre[] getChambres() {
        return chambres;
    }

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

    public void setClient(Client[] client) {
        this.client = client;
    }

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
