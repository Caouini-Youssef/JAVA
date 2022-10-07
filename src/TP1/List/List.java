package TP1.List;

import TP1.Exceptions.WeakExceptions.NotElementList;
import TP1.Structure;

public class List extends Structure implements Cloneable{
    /**
     * Classe qui représente une liste d'entiers
     */

    /** Attribut qui représente la tête de la liste */
    private Node head;

    /**
     * Méthode qui permet d'insérer un élément à la bonne place
     * @param i
     */
    public void insert(int i) throws Exception{
        Node aux=this.head;
        while (aux != null && aux.getInfo() != i)
            aux = aux.getNext();
        if (aux == null)
            this.head = new Node(i,this.head);
    }

    /**
     * Méthode qui permet de supprimer un élément à la bonne place
     * @param i
     */
    public void delete(int i) throws Exception{
        if (this.head.getInfo() == i)
            this.head = this.head.getNext();
        else {
            Node aux = this.head;
            while (aux.getNext() != null && aux.getNext().getInfo() != i)
                aux = aux.getNext();
            if (aux.getNext() != null)
                aux.setNext(aux.getNext().getNext());
            else
                throw new NotElementList(i);
        }
    }

    /**
     * Méthode concrète qui va afficher tous les Maillons attachés à la liste
     */
    @Override
    public void display() {
        Node tmp = head;
        while (tmp != null)
        {
            System.out.println(" -> " + tmp.getInfo());
        }
    }

    /**
     * Méthode concrète qui va supprimer n éléments, en enlevant à chaque fois la tête
     * @param n
     */
    @Override
    public void compact(int n) throws Exception {
        Node tmp = head;
        Node tmp2;
        while(tmp.getNext() != null && n > 0){
            tmp2 = tmp.getNext();
            tmp.setNext(null);
            tmp = tmp2;
        }
    }

    /**
     * Constructeur de la classe TP1.Liste
     * @param m
     */
    public List(Node m) {
        this.head = m;
    }

    public void print() {
        Node aux = this.head;
        do {
            System.out.print(aux.getInfo() + " -> ");
            aux = aux.getNext();
        }while (aux != null);
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            List myList = new List(new Node(5, null));
            myList.insert(4);
            myList.insert(3);
            myList.print();
            myList.delete(5);
            myList.print();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Implémentation de la fonction clone afin de rendre l'objet cloneable
     * @return List
     */
    @Override
    public List clone() {
        try {
            List clone = (List) super.clone();
            clone = new List(new Node(this.head.getInfo(), null));
            Node tmp_orgn = this.head;
            Node tmp_clone = clone.head;
            while(tmp_orgn.getNext() != null){
                tmp_clone.setNext(new Node(tmp_orgn.getNext().getInfo(),null));
                tmp_clone = tmp_clone.getNext();
                tmp_orgn = tmp_orgn.getNext();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

