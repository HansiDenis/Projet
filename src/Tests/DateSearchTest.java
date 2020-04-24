package Tests;

import InterTree.Node;
import InterTree.Tree;

public class DateSearchTest {

    private Node n1, n2, n3;
    private Tree tree;

    public DateSearchTest() {
        n1 = new Node(0, 20);
        n2 = new Node(15, 50);
        n3 = new Node(6, 20);
        tree = new Tree(n3);
        tree.insert(n1);
        tree.insert(n2);
    }


    public void positiveTest() {
        System.out.println(this.tree.dateSearch(12, 24));

    }

    public static void main(String[] args) {

        DateSearchTest ds = new DateSearchTest();
        ds.positiveTest();
    }

}