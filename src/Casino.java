import java.util.HashMap;
import java.util.Random;

public class Casino {
    private static HashMap<Integer, String[]> Roulette = new HashMap<Integer, String[]>(37);
    private Client joueur;
    private int gainpl = 0;
    private int nbj = 20;

    public Casino(Client c) {
        this.joueur = c;
    }

    public void create() {
        Roulette.put(0, new String[]{"zéro", "vert"});
        for (int i = 1; i <= 36; i++) {
            if (i <= 10) {
                if (i % 2 == 0) {
                    Roulette.put(i, new String[]{"pair", "noir"});
                } else {
                    Roulette.put(i, new String[]{"impair", "rouge"});
                }
            } else if (i > 10 && i <= 18) {
                if (i % 2 == 0) {
                    Roulette.put(i, new String[]{"pair", "rouge"});
                } else {
                    Roulette.put(i, new String[]{"impair", "noir"});
                }
            } else if (i > 18 && i <= 28) {
                if (i % 2 == 0) {
                    Roulette.put(i, new String[]{"pair", "noir"});
                } else {
                    Roulette.put(i, new String[]{"impair", "rouge"});
                }
            } else {
                if (i % 2 == 0) {
                    Roulette.put(i, new String[]{"pair", "rouge"});
                } else Roulette.put(i, new String[]{"impair", "noir"});
            }
        }
    }

    public int getGainpl() {
        return gainpl;
    }

    public void miser(String mise, int valeur) {
        int n = roule();
        System.out.println(n);
        switch (mise) {
            case "pair":
                if (gagne(n, "pair")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    nbj += valeur;
                    break;
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                    break;
                }
            case "impair":
                if (gagne(n, "impair")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    nbj += valeur;
                    break;
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                    break;
                }
            case "noir":
                if (gagne(n, "noir")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    nbj += valeur;
                    break;
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                    break;
                }
            case "rouge":
                if (gagne(n, "rouge")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    nbj += valeur;
                    break;
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                    break;
                }
            case "manque":
                if (gagne(n, "manque")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    nbj += valeur;
                    break;
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                    break;
                }
            case "passe":
                if (gagne(n, "passe")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    nbj += valeur;
                    break;
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                    break;
                }
            case "zéro":
                if (gagne(n, "zéro")) {
                    System.out.println("Vous avez gagné et avez multiplié votre mise par 35 !");
                    gainpl += valeur;
                    nbj += valeur;
                    break;
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                    break;
                }


        }
    }

    public int getNbj() {
        if (nbj > 0) {
            return nbj;
        } else return 0;
    }

    public boolean gagne(int n, String mise) {
        System.out.println("Rien ne va plus!");
        switch (mise) {
            case "pair":
                if (Roulette.get(n)[0].equals("pair")) {
                    return true;
                } else {
                    return false;
                }
            case "impair":
                if (Roulette.get(n)[0].equals("impair")) {
                    return true;
                } else {
                    return false;
                }
            case "noir":
                if (Roulette.get(n)[1].equals("noir")) {
                    return true;
                } else {
                    return false;
                }
            case "rouge":
                if (Roulette.get(n)[1].equals("rouge")) {
                    return true;
                } else {
                    return false;
                }
            case "manque":
                if (n <= 18) {
                    return true;
                } else {
                    return false;
                }
            case "passe":
                if (n >= 19) {
                    return true;
                } else {
                    return false;
                }
            case "zéro":
                if (n == 0) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public int roule() {
        Random r = new Random();
        int n = r.nextInt(38) - 1;
        if (n >= 0) return n;
        else return 0;
    }

}