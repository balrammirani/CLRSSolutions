package LinkedList;

import java.util.Hashtable;

/**
 *
 * @author Balram
 */
public class RemoveDuplicate_UnsortedLL {

    public static void removeDuplicate(Node head) {
        Node outer = head;
        while (outer != null && outer.getNext() != null) {
            Node inner = outer;
            while (inner.getNext() != null) {
                if (outer.getData() == inner.getNext().getData()) {
                    Node temp = inner.getNext();
                    inner.setNext(temp.getNext());
                } else {
                    inner = inner.getNext();
                }
            }
            outer = outer.getNext();
        }
    }

    public static void removeDuplicateMethod2(Node head) {
        Hashtable table = new Hashtable();
        Node curr = head;
        Node prev = head;

        while (curr != null) {
            if (curr == head) {
                table.put(curr.getData(), 1);
                curr = curr.getNext();
            } else if (table.containsKey(curr.getData())) {
                Node removeNode = curr;
                prev.setNext(removeNode.getNext());
                removeNode = null;
                curr = prev.getNext();
            } else {
                table.put(curr.getData(), 1);
                prev = curr;
                curr = curr.getNext();
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListBasics ll = new LinkedListBasics();
        ll.insertatLast(1);
        ll.insertatLast(2);
        ll.insertatLast(3);
        ll.insertatLast(2);
        ll.insertatLast(3);
        ll.insertatLast(4);
        ll.insertatLast(1);
        ll.display();
        removeDuplicateMethod2(ll.head);
        System.out.println("");
        ll.display();
    }

}
