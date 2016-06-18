package LinkedList;

import static LinkedList.FindMiddle.findMiddle;

/**
 *
 * @author Balram
 */
public class FindLoop {

    /**
     * @param args the command line arguments
     */
    public static boolean checkLoop(Node head) {
        Node slowptr = head;
        Node fastptr = head;
        while (slowptr != null && fastptr != null && fastptr.getNext() != null) {
            slowptr = slowptr.getNext();
            fastptr = fastptr.getNext().getNext();
            if (slowptr == fastptr) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListBasics ll = new LinkedListBasics();
        ll.insertatFirst(1);

        ll.display();

        ll.insertafter(1, 20);
        ll.insertafter(20, 4);
        ll.insertafter(4, 15);
        ll.insertafter(15, 10);

        /* Create a loop for testing */
        ll.head.getNext().getNext().getNext().setNext(ll.head);
        //Imagine a loop
         /*
         1->20->4->15->10---
         ^                 |
         |                 |
         -------------------
         */
        System.out.println(checkLoop(ll.head));
    }

}
