package TP2.Shapes;

import TP1.Compactable;
import TP2.Dot;
import TP2.TransformStack;

import java.util.Comparator;

public class Image extends Shape implements Compactable,Comparable, Comparator {

    /**
     * Attribut qui représente les différentes formes qui composent l'image
     */
    private Shape[] shapes;

    /**
     * Attribut qui représente le nombre de forme qui compose l'image
     */
    private int number;


    public void add(Shape shape) {
        shapes[number++] = shape;
    }

    /**
     * Constructeur qui prend en paramètre un point afin de définir l'origine et initialise les différentes variables
     * @param origin
     */
    public Image(Dot origin) {
        super(origin);
        number = 0;
        shapes = new Shape[50];
    }

    /**
     * Méthode concrète qui va afficher le nombre de formes dans l'image puis appeler la méthode display de chacune d'entre elles
     */
    @Override
    public void display() {
        System.out.println("number : " + this.number);
        System.out.println("origin : " + super.getOrigin());
        for(Shape shape : shapes) {
            shape.display();
        }
    }

    /**
     * Redéfinition de la méthode par défaut qui va afficher l'origine uniquement
     */
    @Override
    public void lightDisplay() {
        System.out.println("origin : " + super.getOrigin());
    }

    /**
     * Constructeur par défaut qui initialise les différentes variables
     */
    public Image() {
        super(new Dot());
        number = 0;
        shapes = new Shape[100];
    }


    @Override
    public void draw(TransformStack stack) {
        stack.stack(super.getOrigin());
        for (int i=0; i<number; i++)
            shapes[i].draw(stack);
        stack.unstack();
    }

    @Override
    public void move(Dot dot) {
        super.setOrigin(super.getOrigin().add(dot));
    }

    /**
     * Méthode concrète qui va supprimer n éléments, plus précisement à partir de la fin
     * @param n
     */
    @Override
    public void compact(int n) throws Exception {
        while(number >= 0 && n > 0){
            shapes[number] = null;
            number--;
            n--;
        }
    }


    /**
     * Implémentation de la méthode compareTo afin de rendre l'objet comparable
     */
    @Override
    public int compareTo(Object o) {
        Image img = (Image) o;
        return this.number - img.number;
    }

    /**
     *Implémentation de la fonction compare afin de rendre l'objet comparator
     */
    @Override
    public int compare(Object o1, Object o2) {
        Image img1 = (Image) o1;
        Image img2 = (Image) o2;
        return (int) (img1.getOrigin().getY() - img2.getOrigin().getY());
    }
}
