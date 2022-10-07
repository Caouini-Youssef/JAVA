package TP1.BinaryTree;

public class Node {
    /**
     * Classe qui représente le Maillon d'une liste
     */

    /** Attribut qui représente le fils gauche */
    private Node left;

    /** Attribut qui représente le fils droit */
    private Node right;

    /** Attribut qui représente l'information dans le maillon */
    private int info;

    /**
     * Méthode qui retourne le maillon de gauche
     * @return Maillon
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Méthode qui retourne le maillon de droite
     * @return Maillon
     */
    public Node getRight() {
        return right;
    }

    /**
     * Méthode qui retourne l'information contenue dans le maillon
     * @return int
     */
    public int getInfo() {
        return info;
    }


    /**
     * Méthode qui permet de changer le fils gauche
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Méthode qui permet de changer le fils droit
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Méthode qui permet de changer l'information
     * @param info
     */
    public void setInfo(int info) {
        this.info = info;
    }

    /**
     * Constructeur
     * @param left
     * @param right
     * @param info
     */
    public Node(Node left, Node right, int info) {
        this.left = left;
        this.right = right;
        this.info = info;
    }

}
