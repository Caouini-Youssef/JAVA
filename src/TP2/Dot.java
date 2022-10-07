package TP2;

public class Dot {
    /**
     * Classe qui représente un point en 2 dimensions dans un plan
     */

    /**
     * Attribut qui représente la coordonnée x d'un point
     */
    private double x;

    /**
     * Attribut qui représente la coordonnée y d'un point
     */
    private double y;

    /**
     * Constructeur qui initialise les deux paramètres
     * @param x
     * @param y
     */
    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur par défaut qui initialise à 0 les deux attributs
     */
    public Dot() {
        this.x = 0;
        this.y = 0;
    }


    /**
     * Accesseur qui renvoie l'attribut x
     * @return double
     */
    public double getX() {
        return x;
    }

    /**
     * Mutateur qui modifie l'attribut x
     * @return double
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Accesseur qui renvoie l'attribut y
     * @return double
     */
    public double getY() {
        return y;
    }

    /**
     * Mutateur qui modifie l'attribut y
     * @return double
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Méthode qui sert à additioner 2 points (les X et les Y séparement)
     * @param dot
     * @return Dot
     */
    public Dot add(Dot dot) {
        return new Dot(this.x + dot.getX(), this.y + dot.getY());
    }

    @Override
    public String toString() {
        return ("X : " + this.x + " Y :" + this.y);
    }
}
