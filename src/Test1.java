import java.util.Scanner;

public class Test1 {

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
        crHotel();
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

}