package LinkedList;

/**
 *
 * @author Balram
 */
public class SwapPairWise {

    public static void swap(Node a, Node b) {
        int temp = a.getData();
        a.setData(b.getData());
        b.setData(temp);
    }

    public static void pairwiseSwap(Node temp) {
        //Node temp = head;
        while (temp != null && temp.getNext() != null) {
            swap(temp, temp.getNext());
            temp=temp.getNext().getNext();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListBasics ll = new LinkedListBasics();
        for (int i = 1; i <= 5; i++) {
            ll.insertatLast(i);
        }
        pairwiseSwap(ll.head);
        ll.display();
    }

}
