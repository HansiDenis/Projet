package Projet;

import java.util.ArrayList;

public class Node {
    int min;
    int max;
    ArrayList<String> events;

    Node(int mi, int ma, ArrayList<Event> events) {
        min = mi;
        max = ma;
        events = events;
    }

    Node() {
        this(0, 0, null);
    }

    boolean dateequal(Node n) {
        if (this.min == n.min && this.max == n.max) {
            return true;
        }
        return false;
    }

}
