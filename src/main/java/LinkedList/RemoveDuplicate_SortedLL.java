package LinkedList;

/**
 *
 * @author Balram
 */
public class RemoveDuplicate_SortedLL {

    public static void removeDuplicate(Node head) {
        Node temp = head;
        
        if (temp != null) {
            while (temp.getNext() != null) {
                if (temp.getData() == temp.getNext().getData()) {
                    Node removeNode = temp.getNext();
                    temp.setNext(removeNode.getNext());
                    removeNode = null;
                } else {
                    temp = temp.getNext();
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListBasics ll = new LinkedListBasics();
        ll.insertatLast(1);
        ll.insertatLast(1);
        ll.insertatLast(1);
        ll.insertatLast(2);
        ll.insertatLast(3);
        ll.insertatLast(4);
        ll.insertatLast(4);
        ll.display();
        removeDuplicate(ll.head);
        ll.display();
    }
}
