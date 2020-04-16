package Projet;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Tree {
    Node root;
    int dmax;
    Tree right;
    Tree left;

    Tree(Node root, Tree right, Tree left) {
        this.root = root;
        this.right = right;
        this.left = left;
        if (this.right != null) {
            this.dmax = this.right.calcmax(this.right.getMax());
        }
    }

    Tree() {
        this(new Node(), null, null);
    }

    Tree(Node root) {
        this(root, null, null);
    }

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

    int getMax() {
        return this.root.max;
    }

    int calcmax(int max) {
        if (right != null) {
            int maxright = right.getMax();
            if (maxright >= max) {
                max = maxright;
            }
            max = right.calcmax(max);
        }

        if (left != null) {
            int maxleft = left.getMax();
            if (maxleft >= max) {
                max = maxleft;
            }
            max = left.calcmax(max);
        }

        return Math.max(this.getMax(), max);
    }


    void add(Tree n) {
        if (this.root.dateequal(n.root)) {
            this.root.events.addAll(n.root.events);
            LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.root.events);
            ArrayList<String> withoutduplicates = new ArrayList<>(hashSet);
            this.root.events = withoutduplicates;
            this.add(n.right);
            this.add(n.left);
            return;
        }
        if (n.root.min > this.root.min && this.right == null) {
            this.right = n;
            return;
        }
        if (n.root.min < this.root.min && this.left == null) {
            this.left = n;
            return;
        }
        if (n.root.min > this.root.min && !(this.right == null)) {
            this.right.add(n);
        }
        if (n.root.min < this.root.min && !(this.left == null)) {
            this.left.add(n);
        }
    }

    void insert(Node n) {
        if (this.root.dateequal(n)) {
            this.root.events.addAll(n.events);
            LinkedHashSet<String> hashSet = new LinkedHashSet<>(this.root.events);
            ArrayList<String> withoutduplicates = new ArrayList<>(hashSet);
            this.root.events = withoutduplicates;
            return;
        }
        if (this.root.min == n.min && this.root.max != n.max) {
            if (this.root.max <= n.max) {
                this.right.insert(n);
            } else {
                this.left.insert(n);
            }
        }
        if (n.min > this.root.min && this.right == null) {
            this.right.root = n;
            return;
        }
        if (n.min < this.root.min && this.left == null) {
            this.left.root = n;
            return;
        }
        if (n.min > this.root.min) {
            if (n.min < this.right.root.min) {
                Tree temp = this.right;
                this.right = new Tree(n);
                this.right.right = temp;
            } else {
                this.right.insert(n);
            }
        }
        if (n.min < this.root.min) {
            if (n.min > this.left.root.min) {
                Tree temp = this.left;
                this.left = new Tree(n);
                this.left.left = temp;
            } else {
                this.left.insert(n);
            }
        }
    }
}
