package LinkedList;

/**
 *
 * @author Balram
 */
public class Breakinto2Halves {

    private static Node mid, end;

    private static void tortoiseHare(Node head) {
        Node slowptr = head;
        Node fastptr = head;
        while (fastptr.getNext() != head && fastptr.getNext().getNext() != head) {
            slowptr = slowptr.getNext();
            fastptr = fastptr.getNext().getNext();
        }
        if (fastptr.getNext().getNext() == head) {
            fastptr = fastptr.getNext();
        }
        System.out.println("mid=" + slowptr.getData() + " " + "end=" + fastptr.getData());

        mid = slowptr;
        end = fastptr;
    }

    /**
     * Takes start and end nodes and links them to form a circulat linkedlist
     *
     * @param start
     * @param end
     */
    private static void makeitCircular(Node start, Node end) {
        end.setNext(start);
    }

    /**
     * Driver Function
     *
     * @param head head of the linkedlist
     */
    public static void splitList(Node head) {
        tortoiseHare(head);
        Node head_ref = head;
        Node mid_ref = mid.getNext();
        makeitCircular(head_ref, mid);
        makeitCircular(mid_ref, end);
        LinkedListBasics ll = new LinkedListBasics();
        ll.printList(head_ref);
        ll.printList(mid_ref);
    }

    public static void main(String[] args) {
        LinkedListBasics ll = new LinkedListBasics();
        ll.insertatLast(1);
        ll.insertatLast(2);
        ll.insertatLast(3);
        ll.insertatLast(4);
        ll.insertatLast(5);
        ll.insertatLast(6);
        ll.head.getNext().getNext().getNext().getNext().getNext().setNext(ll.head);
        ll.printList(ll.head);
        splitList(ll.head);
    }

}
