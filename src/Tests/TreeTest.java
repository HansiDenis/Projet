package Tests;
/**
 * Authors:MALTESE Salomé et DENIS Hansi
 **/

import InterTree.Node;
import InterTree.Tree;

/**
 * Classe de tests sur le fonctionnement des arbres d'intervalles
 */
public class TreeTest {
    Tree t;

    public TreeTest() {
        Node b = new Node(1, 10);
        this.t = new Tree(b);
    }

    public static void main(String[] args) {
        TreeTest tt = new TreeTest();
        tt.placementTest();
    }

    public void placementTest() {
        Node a = new Node(-1, 10);
        Node c = new Node(1, 10);
        Node d = new Node(2, 12);
        Node e = new Node(0, 9);
        Node f = new Node(1, 12);
        System.out.println("ajout sous-arbre gauche :");
        t.insert(a);
        System.out.println(t);
        System.out.println("ajout sous-arbre droit :");
        t.insert(d);
        System.out.println(t);
        System.out.println("pas de duplication de noeuds(on insère un noeud [1,10]:");
        t.insert(c);
        System.out.println(t);
        System.out.println("entre deux à droite");
        t.insert(f);
        System.out.println(t);
        System.out.println("entre deux à gauche");
        t.insert(e);
        System.out.println(t);
    }
}
