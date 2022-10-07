package TP2;

public interface Displayable {
    /**
     * Méthode abstraite qui permet d'afficher les valeurs des attributs, à redéfinir dans les classes filles
     */
    public abstract void display();

    /**
     * Méthode par défaut qui affiche de manière courte
     */
    public default void lightDisplay() {
        System.out.println("Je ne sais pas Afficher Light");
    }
}
