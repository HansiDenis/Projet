package Tests;
/**
 * Authors:MALTESE Salomé et DENIS Hansi
 **/
import events.*;

import java.util.ArrayList;

public class TypeSearchTest {

    Event e1, e2, e3;

    public TypeSearchTest() {
        e1 = new NBASeries("WorldCup", "China", 100, 120, "Lakers", "Clippers", 20000);
        e2 = new FoodAndDrink(5, 42, "antibes", "bk", "fastfood", "malbouffe");
        e3 = new Comedy(8, 8, "quahog", "taylor swift", "comedie romantique", 2);
    }


    public void positiveTest() {
        System.out.println("Test d'un type existant : ");
        ArrayList<Event> res = AllEvents.getInstance().typeSearch("nba");
        System.out.println(res);
        System.out.println("On teste l'évènement retourné avec instanceof:");
        System.out.println("result.get(0) instanceof NBASeries:" + (res.get(0) instanceof NBASeries));
        System.out.println("Pour les autres évènements créés:");
        System.out.println("e3 instanceof NBASeries:" + (e3 instanceof NBASeries));
        System.out.println("e2 instanceof NBASeries:" + (e2 instanceof NBASeries));


    }

    public void negativeTest(){
        System.out.println("Test d'un type non existant : ");
        System.out.println("résultat :" + AllEvents.getInstance().typeSearch("bar"));
    }

    public void typeSearchTest(){
        positiveTest();
        negativeTest();
    }

    public static void main(String[] args) {

        TypeSearchTest ts = new TypeSearchTest();
        ts.typeSearchTest();
    }

}
