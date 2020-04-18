package Projet;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
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
        Tree t = new Tree(a);
        Tree t1 = new Tree(d);
        Tree tt = new Tree(c, t1, t);
        tt.insert(e);
        tt.insert(f);
        NBASeries nn = new NBASeries("nn", "londres", 100, 120, "Lakers", "Clippers", 20000);
        Event nb = new NBASeries("nn", "londres", 100, 120, "Lakers", "Clippers", 20000);
        System.out.println(nn.reference());
        System.out.println(nb.reference());
        Event s = new SportEvent("boxing", "Paris", 50, 50, "boxe");
        System.out.println(s.reference());
        ArrayList<Event> al = new ArrayList<>();
        al.add(nb);
        al.add(nn);
        al.add(s);
        AllEvents ae = new AllEvents(al);
        System.out.println(ae.typeSearch("sport").get(1) instanceof NBASeries);
        System.out.println(ae.typeSearch("h"));


    }
}
