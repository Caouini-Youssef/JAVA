package TP1.Integers;

import TP1.Exceptions.StrongExceptions.OutOfBounds;
import TP1.Exceptions.WeakExceptions.NotElementIntegers;
import TP1.Structure;

public class Integers extends Structure {
    /**
     * Classe qui représente un ensemble d'entiers ordonnés
     */
    /** Attribut stack qui stocke les entiers */
    private int tab[];
    /** Attribut qui représente le nombre d'éléments dans le tableau */
    private int nb;
    /** Attribut qui représente la taille du tableau */
    private int size;

    /**
     * Constructeur de la classe
     * @param size
     */
    public Integers(int size) {
        this.tab = new int[size];
        this.size = size-1;
        this.nb = 0;
    }

    /**
     * Méthode qui insere un entier
     * @param n
     * @throws Exception
     */
    public void insert(int n) throws Exception{
        if (this.nb == this.size)
            throw new OutOfBounds(n);
        int i = 0;
        while (this.tab[i]<n && i<this.nb-1)
            i++;
        if (this.tab[i]>n) {
            for (int j=this.nb; j>i; j--) {
                this.tab[j] = tab[j-1];
                this.tab[i] = n;
                this.nb++;
            }
        }
        else if(this.tab[i]<n){
            this.tab[this.nb] = n;
            this.nb++;
        }
    }

    /**
     * Méthode qui supprime un entier
     * @param n
     * @throws Exception
     */
    public void delete(int n) throws Exception {
        int i = 0;
        while (this.tab[i]<n && i < this.nb-1) i++;
        if (this.tab[i] == n){
            for (int j=i+1; j<=this.nb-1; j++){
                this.tab[j-1] = this.tab[j];
                this.nb--;
            }
        }
        else
            throw new NotElementIntegers(n);
    }

    /**
     * Méthode concrète qui permet d'afficher la taille ainsi que tous les éléments du tableau
     */
    @Override
    public void display() {
        System.out.println("Taille : " + size);
        System.out.println("Nombre d'éléments : " + nb);
        for (int n : tab)
        {
            System.out.print(" -> " + n);
        }
    }

    /**
     * Méthode concrète qui va supprimer n éléments, plus précisement les derniers
     * @param n
     */
    @Override
    public void compact(int n) {
        while(nb >= 0 && n > 0){
            tab[nb] = 0;
            nb--;
            n--;
        }
    }

    /**
     * Redéfinition de la méthode par défaut qui va rajouter n fois le dernier élément du tableau
     */
    @Override
    public void expand(int n) {
        for(int i=1; i<=n; ++i) {
            tab[nb+i] = tab[nb];
        }
    }

    /**
     * Méthode pour afficher tous les éléments
     */
    public void print() {
        for(int element : this.tab)
        {
            if (element != 0)
                System.out.print(element + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Integers myIntegers = new Integers(10);
            myIntegers.insert(2);
            myIntegers.insert(3);
            myIntegers.insert(5);
            myIntegers.insert(6);
            myIntegers.insert(7);
            myIntegers.insert(8);
            myIntegers.print();
            myIntegers.delete(5);
            myIntegers.delete(2);
            myIntegers.delete(7);
            myIntegers.delete(3);
            myIntegers.print();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}