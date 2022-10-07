package TP1.Exceptions.StrongExceptions;

public class EmptyStack extends StrongException {

    /**
     *
     */
    @Override
    public void printStackTrace() {
        System.err.println("Erreur : La pile est vide, impossible de dépiler");
        System.exit(-1);
    }
}
