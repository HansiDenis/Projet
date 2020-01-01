package idea.core;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Casino {
    private static HashMap<Integer, String[]> Roulette = new HashMap<>(37);

    public void setGainpl(int gainpl) {
        this.gainpl = gainpl;
    }

    private int gainpl = 0;

    public void setNbj(int nbj) {
        this.nbj = nbj;
    }

    private int nbj = 20;

    public Casino() {
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
        System.out.println(n + "--->" + Roulette.get(n)[1]);
        switch (mise) {
            case "pair":
                if (gagne(n, "pair")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    if (nbj >= 0) {
                        nbj += valeur;
                    }
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                }
                break;
            case "impair":
                if (gagne(n, "impair")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    if (nbj >= 0) {
                        nbj += valeur;
                    }
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                }
                break;
            case "noir":
                if (gagne(n, "noir")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    if (nbj >= 0) {
                        nbj += valeur;
                    }
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                }
                break;
            case "rouge":
                if (gagne(n, "rouge")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!!");
                    gainpl += valeur;
                    if (nbj >= 0) {
                        nbj += valeur;
                    }
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                }
                break;
            case "manque":
                if (gagne(n, "manque")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    if (nbj >= 0) {
                        nbj += valeur;
                    }
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                }
                break;
            case "passe":
                if (gagne(n, "passe")) {
                    System.out.println("Vous avez gagné et avez doublé votre mise!");
                    gainpl += valeur;
                    if (nbj >= 0) {
                        nbj += valeur;
                    }
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                }
                break;
            case "zéro":
                if (gagne(n, "zéro")) {
                    System.out.println("Vous avez gagné et avez multiplié votre mise par 35 !");
                    gainpl += 34 * valeur;
                    if (nbj >= 0) {
                        nbj += valeur;
                    }
                } else {
                    System.out.println("Aïe!C'est loupé dommage...Vous aurez plus de chance la prochaine fois!");
                    gainpl -= valeur;
                    nbj -= valeur;
                }
                break;


        }
    }

    public int getNbj() {
        return Math.max(nbj, 0);
    }

    public boolean gagne(int n, String mise) {
        System.out.println("Rien ne va plus!");
        switch (mise) {
            case "pair":
                return Roulette.get(n)[0].equals("pair");
            case "impair":
                return Roulette.get(n)[0].equals("impair");
            case "noir":
                return Roulette.get(n)[1].equals("noir");
            case "rouge":
                return Roulette.get(n)[1].equals("rouge");
            case "manque":
                return n <= 18;
            case "passe":
                return n >= 19;
            case "zéro":
                return n == 0;
            default:
                return false;
        }
    }

    public int roule() {
        Random r = new Random();
        int n = r.nextInt(38) - 1;
        return Math.max(n, 0);
    }

    public void tour() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez vous miser?(rouge/noir/pair/impair/manque/passe) Il ya une mise surprise");
        String mise = sc.nextLine();
        if (!mise.equals("rouge") && !mise.equals("noir") && !mise.equals("pair") && !mise.equals("impair") && !mise.equals("manque") && !mise.equals("passe") && !mise.equals("zéro")) {
            System.out.println("Type de mise renseigné non reconnu veuillez recommencer svp");
            tour();
            return;
        }
        System.out.println("Combien voulez vous miser?Mises entières uniquement");
        int valeur = sc.nextInt();
        this.miser(mise, valeur);
        System.out.println("Résultats de ce tour:");
        System.out.println("Gain total:" + this.getGainpl());
        System.out.println("Jetons restants:" + this.getNbj());
    }

}