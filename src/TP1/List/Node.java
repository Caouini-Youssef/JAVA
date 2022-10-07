package TP1.List;

public class Node {
    /**
     * Classe qui représente le Maillon d'une liste
     */

    /** Attribut qui représente l'information dans le maillon */
    private int info;

    /** Attribut qui représente le maillon suivant accroché */
    private Node next;

    /**
     * Méthode qui renvoie le prochain maillon
     * @return Maillon
     */
    public Node getNext() {
        if (this.next != null)
            return this.next;
        return null;
    }

    /**
     * Méthode qui permet de changer le suivant
     * @param m
     */
    public void setNext(Node m) {
        this.next = m;
    }

    /**
     * Méthode qui sert à renvoyer l'information contenue dans le maillon
     * @return int
     */
    public int getInfo() {
        return this.info;
    }

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }
}
