package TP2.Shapes;
import TP2.Displayable;
import TP2.Dot;
import TP2.TransformStack;

public abstract class Shape implements Displayable {
    /**
     * Attribut qui représente le centre de la forme
     */
    private Dot origin;

    /**
     * Méthode abstraite qui permet de "dessiner" la forme, redéfinie dans les classes filles
     * @param stack
     */
    public abstract void draw(TransformStack stack);

    /**
     * Méthode abstraite qui permet de bouger une forme, redéfinie dans les classes filles
     * @param dot
     */
    public abstract void move(Dot dot);

    /**
     * Accesseur qui permet d'accéder à l'attribut origin
     * @return Dot
     */
    public Dot getOrigin() {
        return origin;
    }

    /**
     * Mutateur qui permet de modifier l'attribut origin
     * @param origin
     */
    public void setOrigin(Dot origin) {
        this.origin = origin;
    }

    /**
     * Constructeur qui permet de créer une forme à l'aide d'un point origine
     * @param origin
     */
    public Shape(Dot origin) {
        this.origin = origin;
    }

    public abstract void display();
}
