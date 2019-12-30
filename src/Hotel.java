import java.text.SimpleDateFormat;
import java.util.Date;

public class Hotel {

    private static int[] numChambre;
    private Client[] client;
    private Chambre[] chambres;
    private int nbSimple;

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

    }

    public void videchambre(int num) {
        this.disponibilite[num] = "libre";
        this.client[num] = new Client();
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
}
