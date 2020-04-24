package Tests;

import InterTree.Node;
import InterTree.Tree;

public class DateSearchTest {

    Node a = new Node(0, 20);
    a.addEvent("pipi");
    a.addEvent("caca");
    Node c = new Node(15, 50);
    c.addEvent("POp");
    Node d = new Node(6, 20);
    d.addEvent("2");
    Node e = new Node(8, 12);
        e.addEvent("Fart");
    Node f = new Node(7, 20);
        f.addEvent("3");
    Node g = new Node(8, 20);
        g.addEvent("4");
    Tree tt = new Tree(c);
        tt.insert(a);
        tt.insert(d);
        tt.insert(e);
        tt.insert(f);
}
