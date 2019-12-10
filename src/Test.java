import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Client c = new Client("Maltese", "Salomé", "10/03/2000", "salome.maltes@gmail.com", "0619310708", "+33", 4);
        Hotel h = new Hotel();
        h.reservation(1, c, 1, "double");
        h.ticket(c);
        h.affichage();
        Casino casino = new Casino(c);
        casino.create();
        casino.miser("pair", 20);
        System.out.println(casino.getGainpl());

        /**Client c = new Client("Maltese", "Salomé", "10/03/2000", "salome.maltes@gmail.com", "0619310708", "+33");
         Hotel h = new Hotel();
         h.reservation(1, c, 1, "double");
         h.ticket(c);
         **/
        //Reception();
        Reservation(h);
    }

    private static Client Reception() {

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
            c = Reception();
        }
        return c;
    }

    private static void Reservation(Hotel h) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel type de chambre voulez-vous réserver ? (simple/double/triple/deluxe)");
        String type = sc.nextLine();
        int[] tab = h.max(type);
        System.out.println(tab[1]);
        while (tab[1] == 0) {
            System.out.println("Quel type de chambre voulez-vous réserver ? (simple/double/triple/deluxe)");
            type = sc.nextLine();
            tab = h.max(type);
        }

    }

}