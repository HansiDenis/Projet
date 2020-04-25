package InterTree;
/**
 * Authors:MALTESE Salomé et DENIS Hansi
 * <p>
 * Classe servant à la représentation des arbres d'intervalles
 * <p>
 * Classe servant à la représentation des arbres d'intervalles
 */
/**
 * Classe servant à la représentation des arbres d'intervalles
 */

import events.AllEvents;
import events.Event;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Tree {
    Node root;
    Tree right;
    Tree left;

    /**
     * Constructeur d'un arbre
     *
     * @param root  noeud servant de racine à l'arbre
     * @param right sous arbre droit
     * @param left  sous arbre gauche
     */
    public Tree(Node root, Tree right, Tree left) {
        this.root = root;
        this.right = right;
        this.left = left;
        if (this.right != null) {
            this.root.dmax = this.right.calcmax(this.right.getRootMax());
        }
    }

    /**
     * Constructeur d'arbre sans sous-arbres
     *
     * @param root noeud racine de l'arbre
     */
    public Tree(Node root) {
        this(root, null, null);
    }

    /**
     * Affichage de l'arbre
     *
     * @return Représentation en String de l'arbre
     */
    public String toString() {
        String s = "\nVALEUR : [" + this.root.min + "," + this.root.max + "] ";
        if (left != null)
            s = s + "GAUCHE : [ " + this.left.root.min + "," + this.left.root.max + " ]";
        if (right != null)
            s = s + "DROITE : [ " + this.right.root.min + "," + this.right.root.max + "] ";
        if (left != null) s = s + left.toString();
        if (right != null) s = s + right.toString();
        return s;
    }

    /**
     * Getter du maximum de la racine de l'arbre
     *
     * @return le maximum de la racine de l'arbre
     */
    int getRootMax() {
        return this.root.max;
    }

    /**
     * Calcul du maximum de l'arbre courant en parcourant récursivementles sous arbres
     * gauche et droit tant qu'ils ne sont pas vides
     *
     * @param max maximum de base(maximum de l'intervalle)
     * @return le maximum absolu de l'arbre d'intervalle
     */
    int calcmax(int max) {
        if (right != null) {
            int maxright = right.getRootMax();
            if (maxright >= max) {
                max = maxright;
            }
            max = right.calcmax(max);
        }

        if (left != null) {
            int maxleft = left.getRootMax();
            if (maxleft >= max) {
                max = maxleft;
            }
            max = left.calcmax(max);
        }

        return max;
    }

    /**
     * Mise à jour récursive de tous les dmax de chacun des noeuds de l'arbre
     */
    void updateDMaxes() {
        if (this.right == null) {
            this.root.dmax = this.root.max;
        }
        if (this.left != null) {
            this.left.updateDMaxes();
        }
        if (this.right != null) {
            this.root.dmax = this.right.calcmax(this.right.getRootMax());
            this.right.updateDMaxes();
        }
    }

    /**
     * Méthode non utiisée qui a servit de base à insert et qui permet la concaténation d'
     * un arbre à la suite d'un autre(nous n'étions intitialement pas sûrs du sens
     * d'insertion)
     *
     * @param n arbre à ajouter
     */
    void add(Tree n) {
        if (this.root.dateEqual(n.root)) {
            this.root.events.addAll(n.root.events);
            LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.root.events);
            this.root.events = new ArrayList<>(hashSet);
            this.add(n.right);
            this.add(n.left);
            this.updateDMaxes();
            return;
        }
        if (n.root.min > this.root.min && this.right == null) {
            this.right = n;
            this.updateDMaxes();
            return;
        }
        if (n.root.min < this.root.min && this.left == null) {
            this.left = n;
            this.updateDMaxes();
            return;
        }
        if (n.root.min > this.root.min) {
            this.right.add(n);
        }
        if (n.root.min < this.root.min && !(this.left == null)) {
            this.left.add(n);
        }
    }

    /**
     * Insertion d'un noeud dans l'arbre en le classant d'abord par rapport à sa borne
     * gauche puis s'il y a égalité, par sa borne droite
     *
     * @param n le noeud que l'on veut insérer dans l'arbre
     */
    public void insert(Node n) {
        if (this.root.dateEqual(n)) {
            this.root.addEvents(n.events);
            this.updateDMaxes();
            return;
        }
        if (this.root.min == n.min && this.root.max != n.max) {
            if (this.root.max < n.max) {
                if (this.right != null) {
                    this.replaceRight(n);
                } else {
                    this.right = new Tree(n);
                    this.updateDMaxes();
                    return;
                }
            } else {
                if (this.left != null) {
                    this.replaceLeft(n);
                } else {
                    this.left = new Tree(n);
                    this.updateDMaxes();
                    return;
                }
            }
        }
        if (n.min > this.root.min) {
            if (this.right == null) {
                this.right = new Tree(n);
                this.updateDMaxes();
                return;
            }
            this.replaceRight(n);
        }
        if (n.min < this.root.min) {
            if (this.left == null) {
                this.left = new Tree(n);
                this.updateDMaxes();
                return;
            }
            this.replaceLeft(n);
        }
    }

    /**
     * Méthode permettant de remplacer si besoin la racine du sous arbe droit
     *
     * @param n noeud à placer
     */
    void replaceRight(Node n) {
        if (n.min < this.right.root.min) {
            Tree temp = this.right;
            this.right = new Tree(n);
            this.right.right = temp;
            this.updateDMaxes();
        } else {
            this.right.insert(n);
        }
    }

    /**
     * Méthode permettant de remplacer si besoin la racine du sous arbe gauche
     *
     * @param n noeud à placer
     */
    void replaceLeft(Node n) {
        if (n.min > this.left.root.min) {
            Tree temp = this.left;
            this.left = new Tree(n);
            this.left.left = temp;
            this.updateDMaxes();
        } else {
            this.left.insert(n);
        }
    }

    /**
     * Recherche par date
     *
     * @param mi jour de début de la recherche
     * @param ma jour de fin de la recherche
     * @return ArrayList de String correspondant aux  références des évènements répondant
     * à la recherche
     */
    public ArrayList<String> dateSearch(int mi, int ma) {
        ArrayList<String> found = new ArrayList<>();
        if (mi > ma) {
            System.out.println("Erreur :minimum supérieur au maximum recherche au résultat nul. ");
            return found;
        }
        if (this.root.max >= mi && this.root.min <= ma) {
            found.addAll(this.root.events);
        }
        if (this.left != null) {
            if (this.left.calcmax(this.left.getRootMax()) >= mi) {
                found.addAll(this.left.dateSearch(mi, ma));
            }
        }
        if (this.right != null) {
            if (this.root.dmax >= mi) {
                found.addAll(this.right.dateSearch(mi, ma));
            }
        }
        return found;
    }

    /**
     * Recherche croisée type/date
     *
     * @param mi   jour de début de la recherche
     * @param ma   jour de fin de la recherche
     * @param type type d'évènements recherchés
     * @return liste (éventuellement vide) d'évènements du type souhaité et dont les dates
     * intersèctent l'intervalle de recherche
     */
    public ArrayList<Event> mixedSearch(int mi, int ma, String type) {
        ArrayList<Event> mixedRes = new ArrayList<>();
        ArrayList<String> dateRes = this.dateSearch(mi, ma);
        ArrayList<Event> typeRes = AllEvents.getInstance().typeSearch(type);
        for (Event res : typeRes) {
            if (dateRes.contains(res.reference())) {
                mixedRes.add(res);
            }

        }
        LinkedHashSet<Event> hashSet = new LinkedHashSet<>(mixedRes);
        mixedRes = new ArrayList<>(hashSet);
        return mixedRes;
    }

    /**
     * Ajout d'un évènement et de son noeud  correspondant dans l'arbre
     *
     * @param event évènement à ajouter à l'arbre
     */
    public void addEvent(Event event) {
        Node n = new Node(event.getStart(), event.getEnd());
        n.addEvent(event);
        this.insert(n);
    }
}
