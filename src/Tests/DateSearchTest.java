package Tests;

import InterTree.Node;
import InterTree.Tree;

public class DateSearchTest {

    private Node n1, n2, n3;
    private Tree tree;
    private String ev1 = new String("ev1");
    private String ev2 = new String("ev2");
    private String ev3 = new String("ev3");

    public DateSearchTest() {
        n1 = new Node(0, 20);
        n1.addEvent(ev1);
        n2 = new Node(15, 50);
        n2.addEvent(ev2);
        n3 = new Node(6, 20);
        n3.addEvent(ev3);
        tree = new Tree(n3);
        tree.insert(n1);
        tree.insert(n2);
    }


    public void positiveTest() {
        System.out.println("Test d'une date correcte qui intersecte l'arbre : ");
        System.out.println(tree.dateSearch(4, 8));
        System.out.println("Test d'une date correcte qui intersecte tous les noeuds de l'arbre : ");
        System.out.println(tree.dateSearch(12, 24));
        System.out.println("Test d'une date correcte qui n'intersecte pas l'arbre : ");
        System.out.println(tree.dateSearch(53, 56));
    }

    public void negativeTest(){
        System.out.println("Test d'une date incorrecte (début > fin) : ");
        System.out.println(tree.dateSearch(12, 8));
    }

    public void dateSearchTest(){
        positiveTest();
        negativeTest();
    }

    public static void main(String[] args) {

        DateSearchTest ds = new DateSearchTest();
        ds.dateSearchTest();
    }

}