package TP1.BinaryTree;

public class BinaryTree {
    /**
     * Classe qui représente un arbre binaire
     */

    /**
     * Attribut qui représente la tête de l'arbre
     */
    private Node head;

    /**
     * Méthode qui retourne la tête de l'arbre
     * @return Maillon
     */
    public Node getHead() {
        return head;
    }

    /**
     * Méthode qui permet de modifier la tête de l'abre
     * @param head
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Constructeur par défaut
     * @param head
     */
    public BinaryTree(Node head) {
        this.head = head;
    }

    /**
     * Méthode qui permet d'insérer à la bonne place le maillon passé en paramètre
     * @param info
     */
    void insert(int info)  {
        head = insert_Recursive(head, info);
    }

    /**
     * Méthode qui insère récursivement un élément
     * @param head
     * @param info
     * @return Maillon
     */
    Node insert_Recursive(Node head, int info) {
        //tree is empty
        if (head == null) {
            head = new Node(null, null, info);
            return head;
        }
        //traverse the tree
        if (info < head.getInfo())     //insert in the left subtree
            head.setLeft(insert_Recursive(head.getLeft(), info));
        else if (info > head.getInfo())    //insert in the right subtree
            head.setRight(insert_Recursive(head.getRight(), info));
        // return pointer
        return head;
    }

    int minValue(Node root)  {
        //initially minval = root
        int minval = head.getInfo();
        //find minval
        while (root.getLeft() != null)  {
            minval = root.getLeft().getInfo();
            root = root.getLeft();
        }
        return minval;
    }

    /**
     * Méthode qui supprime un Maillon
     * @param info
     */
    void deleteinfo(int info) {
        head = delete_Recursive(head, info);
    }

    /**
     * Méthode qui supprime un Maillon récursivement
     * @param head
     * @param info
     * @return Maillon
     */
    Node delete_Recursive(Node head, int info)  {
        //tree is empty
        if (head == null)  return head;

        //traverse the tree
        if (info < head.getInfo())     //traverse left subtree
            head.setLeft(delete_Recursive(head.getLeft(), info));
        else if (info > head.getInfo())  //traverse right subtree
            head.setRight(delete_Recursive(head.getRight(), info));
        else  {
            // Maillon contains only one child
            if (head.getLeft() == null)
                return head.getRight();
            else if (head.getRight() == null)
                return head.getLeft();

            // Maillon has two children;
            //get inorder successor (min value in the right subtree)
            head.setInfo(minValue(head.getRight()));

            // Delete the inorder successor
            head.setRight(delete_Recursive(head.getRight(), head.getInfo()));
        }
        return head;
    }

    /**
     * Fonction de test main
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree myArbre = new BinaryTree(new Node(null,null,6));
        myArbre.insert(8);
        myArbre.insert(4);
        myArbre.insert(9);
        myArbre.deleteinfo(4);
        myArbre.deleteinfo(8);
    }
}
