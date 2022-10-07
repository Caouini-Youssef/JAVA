package TP2.Shapes;

import TP2.Dot;
import TP2.TransformStack;

public class Segment extends Shape{
    /**
     * Classe qui décrit un Segment avec un point origine et un point final
     */

    /**
     * Attribut qui représente le point final d'un segment
     */
    private Dot end;

    /**
     * Accesseur qui retourne l'attribut origin
     * @return Dot
     */
    public Dot getOrigin() {
        return super.getOrigin();
    }

    /**
     *  Mutateur qui modifie l'attribut origin
     * @param origin
     */
    public void setOrigin(Dot origin) {
        super.setOrigin(origin);
    }

    /**
     * Méthode concrète qui affiche l'origine ainsi que end
     */
    @Override
    public void display() {
        System.out.println("origin : " + super.getOrigin());
        System.out.println("end : " + end);
    }

    /**
     * Accesseur qui retourne l'attribut end
     * @return Dot
     */
    public Dot getEnd() {
        return end;
    }

    /**
     * Mutateur qui modifie l'attribut end
     * @param end
     */
    public void setEnd(Dot end) {
        this.end = end;
    }

    /**
     * COnstructeur qui initialise les deux points d'un segment
     * @param origin
     * @param end
     */
    public Segment(Dot origin, Dot end) {
        super(origin);
        this.end = end;
    }

    @Override
    public void draw(TransformStack stack) {
        System.out.println("Un segment avec comme origine : " + super.getOrigin().add(stack.getCurrentTransform()) + " et comme fin : " + this.end.add(stack.getCurrentTransform()));
    }

    @Override
    public void move(Dot dot) {
        super.setOrigin(super.getOrigin().add(dot));
        end = end.add(dot);
    }
}
