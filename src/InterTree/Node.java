package InterTree;
/**
 * Classe représentant les noeuds de l'arbre d'intervalles
 */

import events.Event;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Node {
    int min;
    int max;
    int dmax;
    ArrayList<String> events;

    /**
     * Constructeur avec tous les paramètres
     *
     * @param mi     minimum de l'intervalle
     * @param ma     maximum de l'intervalle
     * @param events ArrayList des références des évènements associés aux dates du noeud
     */
    Node(int mi, int ma, ArrayList<String> events) {
        min = mi;
        max = ma;
        dmax = this.max;
        this.events = events;
    }

    /**
     * Constructeur sans évènements associés( on met une liste vide)
     *
     * @param mi minimum de l'intervalle
     * @param ma maximum de l'intervalle
     */
    public Node(int mi, int ma) {
        this.min = mi;
        this.max = ma;
        this.events = new ArrayList<>();
    }

    /**
     * Vérifie si les dates de deux intervalles sont les mêmes
     *
     * @param n noeud avec lequel on veut comparer les dates
     * @return vrai si les dates sont les mêmes, faux sinon
     */
    boolean dateEqual(Node n) {
        return this.min == n.min && this.max == n.max;
    }

    /**
     * Ajout de la référence d'un évènement(si elle en est une) à la liste de références du
     * noeud
     * @param event éventuelle référence d'un évènement que l'on veut ajouter au noeud
     */
    public void addEvent(String event) {
        if (this.events == null) {
            this.events = new ArrayList<>();
        }
        this.events.add(event);
        //Processus d'unification des évènements de la liste
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.events);
        this.events = new ArrayList<>(hashSet);
    }

    /**
     * Ajout de la référence d'un évènement dans la liste du noeud
     *
     * @param event évènement dont on va récupérer la référence et l'ajouter à la liste
     *              du noeud
     */
    void addEvent(Event event) {
        if (this.events == null) {
            this.events = new ArrayList<>();
        }
        this.events.add(event.reference());
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.events);
        this.events = new ArrayList<>(hashSet);
    }

    /**
     * Ajout de références de plusieurs évènements
     *
     * @param events ArrayList de références d'évènements
     */
    void addEvents(ArrayList<String> events) {
        if (this.events == null) {
            this.events = new ArrayList<>();

        }
        this.events.addAll(events);
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.events);
        this.events = new ArrayList<>(hashSet);
    }

    /**
     * Méthode d'affichage du noeud d'intervalles
     *
     * @return affichage textuel du noeud
     */
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