package TP2;

public class TransformStack {
    /**
     * Classe qui représente la pile des transformations par un tableau de points de décalage
     */

    /**
     * Attribut qui représente la pile des transformations par un tableau de points
     */
    private Dot[] dots;

    /**
     * Attribut qui représente le sommet de la pile des transformations
     */
    private int index;

    /**
     * Constructeur qui prend en paramètre la taille que l'on souhaite donner à la pile
     * @param size
     */
    public TransformStack(int size) {
        this.dots = new Dot[size];
        this.index = 0;
        this.dots[0] = new Dot();
    }

    /**
     * Méthode qui retourne l'accès à la transformation actuelle
     * @return Dot
     */
    public Dot getCurrentTransform() {
        return dots[index];
    }

    /**
     * Méthode qui empile une nouvelle transformation sur la pile
     * @param dot
     */
    public void stack(Dot dot) {
        if (index<dots.length) dots[++index]=dot.add(dots[index-1]);
    }

    /**
     * Méthode qui revient à la transformation précédente
     * @return Dot
     */
    public Dot unstack() {
        index--;
        return dots[index+1];
    }
}
