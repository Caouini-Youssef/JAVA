package TP1.Exceptions.StrongExceptions;

public class OutOfBounds extends StrongException {
    public OutOfBounds(int index) {
        this.index = index;
    }

    private int index;
    /**
     *
     */
    @Override
    public void printStackTrace() {
        System.err.println("Erreur : L'index n°" + index + " est hors limite");
        System.exit(-1);
    }
}
