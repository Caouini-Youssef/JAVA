package TP2.Shapes;

import TP2.Dot;
import TP2.TransformStack;
import TP4.Infos;

@Infos(Date = 2012)
public class Circle extends Shape {
    /**
     * Classe qui représente un cercle décrit par un point d'origine et un rayon
     */
    
    /**
     * Attribut qui représente le rayon d'un cercle
     */
    private double radius;

    /**
     * Accesseur qui renvoie le point origine
     * @return Dot
     */
    public Dot getOrigin() {
        return super.getOrigin();
    }

    /**
     * Mutateur qui permet de modifier le point d'origine
     * @param origin
     */
    public void setOrigin(Dot origin) {
        super.setOrigin(origin);
    }

    /**
     * Méthode concrète qui affiche l'origine ainsi que le radius
     */
    @Override
    public void display() {
        System.out.println("origin : " + super.getOrigin());
        System.out.println("radius : " + this.radius);
    }

    /**
     * Accesseur qui renvoie le rayon
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Mutateur qui permet de modifier le rayon
     * @param radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     *
     */
    @Override
    public void draw(TransformStack stack) {
        System.out.println("Un cercle avec comme radius : " + radius + " et comme coordonnées : " + super.getOrigin().add(stack.getCurrentTransform()));
    }

    /**
     *
     * @param dot
     */
    @Override
    public void move(Dot dot) {
        super.setOrigin(super.getOrigin().add(dot));
    }

    /**
     * Constructeur qui initialise les attributs origin et radius
     * @param origin
     * @param radius
     */
    public Circle(Dot origin, double radius) {
        super(origin);
        this.radius = radius;
    }
}
