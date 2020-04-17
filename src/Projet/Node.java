package Projet;

import java.util.ArrayList;


public class Node {
    int min;
    int max;
    ArrayList<String> events;

    Node(int mi, int ma, ArrayList<String> events) {
        min = mi;
        max = ma;
        this.events = events;
    }

    Node(int mi, int ma) {
        this(mi, ma, null);
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

    void addEvent(String event) {
        if (this.events == null) {
            this.events = new ArrayList<String>();
            this.events.add(event);
        } else {
            this.events.add(event);
        }
    }

    void addEvent(Event event) {
        if (this.events == null) {
            this.events = new ArrayList<String>();
            this.events.add(event.reference());
        } else {
            this.events.add(event.reference());
        }
    }

    void addEvents(ArrayList<String> events) {
        if (this.events == null) {
            this.events = new ArrayList<String>();
            this.events.addAll(events);
        } else {
            this.events.addAll(events);
        }
    }

    void addEvents2(ArrayList<Event> events) {
        if (this.events == null) {
            this.events = new ArrayList<String>();
            for (Event event : events) {
                this.events.add(event.reference());
            }
        } else {
            for (Event event : events) {
                this.events.add(event.reference());
            }
        }
    }

    public String toString() {
        String s = "Références des évènements du jour " + this.min + " au jour " + this.max + " : \n";
        if (this.events != null) {
            for (String event : this.events) {
                s = s + event + "\n";
            }
        } else {
            s = s + "Pas d'évènements pour cette période";
        }
        return s;
    }
}