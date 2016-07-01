package LinkedList;

/**
 *
 * @author Balram
 */
public class ReverseLLinGroups {

    // Reverses the linked list in groups of size k and returns the pointer to the new head node.
    public static Node reverse(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;

        //reverse first k nodes of the linked list
        while (current != null && count < k) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node 
         Recursively call for the list starting from current.
         And make rest of the list as next of first node */
        if (next != null) {
            head.setNext(reverse(next, k));
        }

        // prev is new head of the input list
        return prev;
    }

    public static void main(String[] args) {
        /* Created Linked list is 1->2->3->4->5->6->7->8 */
        LinkedListBasics ll = new LinkedListBasics();
        for (int i = 1; i <= 8; i++) {
            ll.insertatLast(i);
        }

        System.out.println("Given linked list");
        ll.display();
        ll.head = reverse(ll.head, 6);

        System.out.println("Reversed Linked list");
        ll.display();
    }

}
