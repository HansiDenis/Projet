package HotelBay;

import java.text.*;
import java.util.Date;

public class Hotel {

    private static int[] numChambre = new int[40];
    private Client[] client;
    private Chambre[] chambres;
    private int nbSimple;
    private int nbDouble;
    private int nbTriple;
    private int nbDeluxe;
    private String[] disponibilite;

    public Hotel() {
        this(10, 10, 10, 10);
    }

    //Test validite nb total = 100
    public Hotel(int nbSimple, int nbDouble, int nbTriple, int nbDeluxe) {
        this.nbSimple = nbSimple;
        this.nbDouble = nbDouble;
        this.nbTriple = nbTriple;
        this.nbDeluxe = nbDeluxe;
        chambres = new Chambre[40];
        disponibilite = new String[40];
        client = new Client[40];
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
        for (int i = 0; i < 40; i++) {
            disponibilite[i] = "libre";
            numChambre[i] = i + 1;
        }

    }

    public void affichage() {
        for (int i = 0; i < 40; i++) {
            String c = "";
            if (client[i] == null) {
                c = "aucun";
            } else {
                c = client[i].getNom();
            }
            System.out.println(numChambre[i] + "               " + chambres[i].getType() + "               " + disponibilite[i] + "               " + c);
        }
    }

    //grand while avec c=[3 1] puis c=max(type)
    public int[] max(String type) {
        int max = 0;
        int b = 1;
        int[] res = {max, b};
        //while(b){
        //System.out.println("Quel type de chambre voulez-vous réserver ?(simple/double/triple/deluxe)");
        switch (type) {
            case "simple":
                max = 1;
                break;
            case "double":
                max = 2;
                break;
            case "triple":
                max = 3;
                break;
            case "deluxe":
                max = 2;
                break;
            default:
                System.out.println("Mauvais type de chambre renseigné");
                b = 0;
                break;
        }
        return res;
    }

    public int reservation(int max, Client c, int n, String type) { //n: nombre de personnes qu'a dit le client
        //Scanner sc = new Scanner(System.in);

        //System.out.println("Combien de personnes occuperont la chambre?");
        //int n = sc.nextInt();
        if (n > max) {
            System.out.println("Vous ne pouvez pas être autant que ça dans cette chambre, veuillez réaliser une nouvelle réservation.");
            return 0;
        } else {
            if (this.disponibilite(type) == -1) {
                return 0;
            } else {
                int numChambre = this.disponibilite(type);
                disponibilite[numChambre - 1] = "occupée";
                client[numChambre - 1] = c;
                return 2;
            }

        }
    }

    public int disponibilite(String type) {
        int b = 0;
        switch (type) {
            case "simple":
                for (int i = 0; i < nbSimple; i++) {
                    b = i;
                    if (disponibilite[i] == "libre") {
                        break;
                    }
                    if (disponibilite[nbSimple - 1] == "occupée") {
                        return b = -1;
                    }
                }
                break;
            case "double":
                for (int i = nbSimple; i < nbSimple + nbDouble; i++) {
                    b = i;
                    if (disponibilite[i] == "libre") {
                        break;
                    }
                    if (disponibilite[nbSimple + nbDouble - 1] == "occupée") {
                        return b = -1;
                    }

                }
                break;
            case "triple":
                for (int i = nbSimple + nbDouble; i < nbSimple + nbDouble + nbTriple; i++) {
                    b = i;
                    if (disponibilite[i] == "libre") {
                        break;
                    }
                    if (disponibilite[nbSimple + nbDouble + nbTriple - 1] == "occupée") {
                        return b = -1;
                    }
                }
                break;
            case "deluxe":
                for (int i = nbSimple + nbDouble + nbTriple; i < 40; i++) {
                    b = i;
                    if (disponibilite[i] == "libre") {
                        break;
                    }
                    if (disponibilite[nbSimple + nbDouble + nbTriple + nbDeluxe] == "occupée") {
                        return b = -1;
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
        while (client[i] != c) {
            i += 1;
        }
        numChambre = i + 1;
        String type = chambres[i].getType();
        System.out.println("Chambre n°: " + numChambre + "       Type de chambre : " + type);
    }


}