package Tests;

import events.*;

public class TypeSearchTest {

    Event e1, e2, e3;

    public TypeSearchTest() {
        e1 = new NBASeries("WorldCup", "China", 100, 120, "Lakers", "Clippers", 20000);
        e2 = new FoodAndDrink(5,42,"antibes","bk","fastfood");
        e3 = new Comedy(8,8,"quahog","taylor swift","comedie romantique");
    }


    public void positiveTest() {
        System.out.println("Test d'un type existant : ");
        System.out.println(AllEvents.getInstance().typeSearch("nba"));


    }

    public void negativeTest(){
        System.out.println("Test d'un type non existant : ");
        System.out.println(AllEvents.getInstance().typeSearch("bar"));
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
