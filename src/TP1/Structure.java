package TP1;

import TP2.Displayable;
import TP2.Dot;

public abstract class Structure implements Displayable,Compactable {
    /**
     * Méthode abstraite qui permet d'insérer un entier, à redéfinir dans les classes filles
     * @param n
     * @throws Exception
     */
    public abstract void insert(int n) throws Exception;

    /**
     * Méthode abstraite qui permet de supprimer un entier, à redéfinir dans les classes filles
     * @param n
     * @throws Exception
     */
    public abstract void delete(int n) throws Exception;

    public abstract void display();

    public abstract void compact(int n) throws Exception;

}
