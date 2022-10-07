package TP1;

public interface Compactable {
    /**
     * Méthode abstraite qui permet de supprimer un nombre n d'éléments
     */
    public abstract void compact(int n) throws Exception;

    /**
     * Méthode par défaut qui affiche de manière courte au lieu de supprimer
     */
    public default void expand(int n){
        System.out.println("Je ne sais pas dilater");
    }
}
