import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Client c = new Client("Maltese", "Salomé", "10/03/2000", "salome.maltes@gmail.com", "0619310708", "+33", 4);
        /**tel h = new Hotel();
         h.reservation(1, c, 1, "double");
         h.ticket(c);
         h.affichage();
         Casino casino = new Casino(c);
         casino.create();
         casino.miser("pair", 20);
         System.out.println(casino.getGainpl());
         crHotel();
         partie(c);**/
        CoInt(c);
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
        System.out.println("Que voulez vous miser?((rouge/noir/pair/impair/manque/passe)*2/zéro(*35))");
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
        System.out.println("Bienvenue au casino client" + c.getNom());
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

    private static void plong(Client c) {
        System.out.println("Souhaitez vous profiter de l'activité de plongée?(o/n)");
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        int l = 0;
        Plongee def = new Plongee();
        if (rep.equals("o")) {
            def.affichageTarifs();
            System.out.println("Combien de baptêmes souhaitez vous?");
            int n = sc.nextInt();
            if (c.getDuree() < 10) {
                System.out.println("Votre temps de séjour n'est pas assez long pour participer à la croisière");
                l = 0;
            } else {
                System.out.println("Combien de croisières voulez vous effectuer?");
                l = sc.nextInt();
            }
            Plongee p = new Plongee(n, l);
            //Rajouter tableau de présence à l'hôtel
            p.Prix();
            c.setNote(c.getNote() + p.total());
        }
        System.out.println("Votre note de frais a bien été mise à jour");
    }

    private static void CoInt(Client c) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Combien d'heures avez vous passé sur internet aujourd'hui.");
        int t = sc.nextInt();
        ConnexionInternet co = new ConnexionInternet(t);
        System.out.println("La conexion internet est facturée 10euros de l'heure.Votre note de frais a été mise à jour.");
        double p = co.getPrix();
        c.setNote(c.getNote() + p);
    }


}