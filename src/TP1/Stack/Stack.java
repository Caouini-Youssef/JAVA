package TP1.Stack;

import TP1.Exceptions.StrongExceptions.EmptyStack;

/**
 * Classe TP1.Pile du TP1
 */

public class Stack<E> {
    /** Attribut stack qui stocke les entiers */
    private E stack[];
    /** Attribut cursor qui définit le curseur actuel */
    private int cursor;
    /** Attribut qui représente le nombre d'éléments dans la pile */
    private int nb;
    /** Attribut qui représente la taille du tableau */
    private int size;

    /**
     * Méthode qui empile un entier (mettre un entier au dernier emplacement)
     * @param number
     * @throws Exception
     */
    public void empiler(E number) throws Exception {
        if (cursor != size) {
            this.stack[cursor] = number;
            this.cursor++;
            this.nb++;
        }
        else
            throw new Exception("TP1.Pile pleine");
    }

    /**
     * Méthode qui dépile un entier (enlever l'entier à la fin du tableau)
     * @return int
     * @throws Exception
     */
    public E depiler() throws Exception {
        if (cursor != 0)
        {
            E tmp = this.stack[cursor-1];
            this.cursor--;
            this.nb--;
            return tmp;
        }
        else
            throw new EmptyStack();
    }

    /**
     * Prédicat qui indique si la pile est pleine ou non
     * @return boolean
     */
    public boolean pleine() {
        if (cursor == size)
            return true;
        return false;
    }

    /**
     * Prédicat qui indique si la pile est vide ou non
     * @return boolean
     */
    public boolean vide() {
        if (cursor == 0)
            return true;
        return false;
    }

    /**
     * Constructeur de la classe
     * @param size
     */
    public Stack(int size) {
        //this.stack = new E[size];
        this.stack = (E[]) new Object[size];
        this.size = size-1;
        this.cursor = 0;
        this.nb = 0;
    }

    public static void main(String[] args) {
        try {
            Stack<Integer> myStack = new Stack<Integer>(5);
            System.out.println(myStack.vide());
            System.out.println(myStack.pleine());
            myStack.empiler(5);
            Integer tmp = myStack.depiler();
            System.out.println(tmp);
            myStack.empiler(5);
            myStack.empiler(5);
            myStack.empiler(5);
            myStack.empiler(5);
            System.out.println(myStack.pleine());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
