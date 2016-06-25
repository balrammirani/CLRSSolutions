package Tree;

/**
 *
 * @author Balram
 */
public class DemoTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BSTNode root = null;
        BSTBasics ll = new BSTBasics();
        root = ll.insert(11, root);
        root = ll.insert(15, root);
        root = ll.insert(5, root);
        System.out.println(ll.getMin(root));
        System.out.println(ll.getMax(root));
        ll.levelOrderTraversal(root);//OrderTraversal(root);
    }

}
