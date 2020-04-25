package Tests;
/**
 * Authors:MALTESE Salomé et DENIS Hansi
 **/

import events.AllEvents;
import events.Event;
import events.FoodAndDrink;
import events.NBASeries;

public class RefSearchTest {

    Event e1, e2;
    String ref1, ref2;

    public RefSearchTest() {
        e1 = new NBASeries("WorldCup", "China", 100, 120, "Lakers", "Clippers", 20000);
        e2 = new FoodAndDrink(5,42,"antibes","bk","fastfood","burger");
        ref1 = e1.reference();
        ref2 = e2.reference();
    }


    public void positiveTest() {
        Event res = AllEvents.getInstance().refSearch("FDE-fa2-5-42");
        System.out.println("Test d'une reference existante : ");
        System.out.println("Evenement trouvé.\nRéférence correspondante : " + res.reference());
        res.present();
    }

    public void negativeTest(){
        System.out.println("Test d'une référence non existante : ");
        Event res = AllEvents.getInstance().refSearch("FDE");
        System.out.println("Résultat de hasNoType:" + res.hasNoType() + "\n true donc l'évènement est vide");

    }

    public void refSearchTest(){
        System.out.println("Tests positifs : ");
        positiveTest();
        System.out.println("Tests négatifs : ");
        negativeTest();
    }

    public static void main(String[] args) {

        RefSearchTest rs = new RefSearchTest();
        rs.refSearchTest();
    }

}


