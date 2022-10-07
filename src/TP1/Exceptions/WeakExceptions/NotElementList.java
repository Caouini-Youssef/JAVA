package TP1.Exceptions.WeakExceptions;

public class NotElementList extends WeakException {

    public NotElementList(int index) {
        this.index = index;
    }

    private int index;

    /**
     *
     */
    @Override
    public void printStackTrace() {
        System.err.println("Erreur : Élément " + index + " n'a pas été trouvé dans la liste");
    }
}
