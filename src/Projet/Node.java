package Projet;

import java.util.ArrayList;
import java.util.LinkedHashSet;


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

    boolean dateEqual(Node n) {
        return this.min == n.min && this.max == n.max;
    }

    void addEvent(String event) {
        if (this.events == null) {
            this.events = new ArrayList<>();
        }
        this.events.add(event);
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.events);
        this.events = new ArrayList<>(hashSet);
    }

    void addEvent(Event event) {
        if (this.events == null) {
            this.events = new ArrayList<>();
        }
        this.events.add(event.reference());
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.events);
        this.events = new ArrayList<>(hashSet);
    }

    void addEvents(ArrayList<String> events) {
        if (this.events == null) {
            this.events = new ArrayList<>();

        }
        this.events.addAll(events);
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.events);
        this.events = new ArrayList<>(hashSet);
    }

    void addEvents2(ArrayList<Event> events) {
        if (this.events == null) {
            this.events = new ArrayList<>();
            for (Event event : events) {
                this.events.add(event.reference());
            }
        } else {
            for (Event event : events) {
                this.events.add(event.reference());
            }
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.events);
        this.events = new ArrayList<>(hashSet);
    }

    public String toString() {
        StringBuilder s = new StringBuilder("Références des évènements du jour " + this.min + " au jour " + this.max + " : \n");
        if (this.events != null) {
            for (String event : this.events) {
                s.append(event).append("\n");
            }
        } else {
            s.append("Pas d'évènements pour cette période");
        }
        return s.toString();
    }
}