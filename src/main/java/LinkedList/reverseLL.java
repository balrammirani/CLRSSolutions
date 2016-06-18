/*
 * Reverse Linked List 
 */
package LinkedList;

/**
 *
 * @author Balram
 */
public class reverseLL {

    Node temp, head, prev, current, next;
    int size = 0;

    public void insertatLast(int data) {
        Node add = new Node(data, null);
        size++;

        if (head == null) {
            head = new Node();
            head = add;
        } else {

            temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(add);
        }
    }

    public void display() {
        temp = head;
        while (true) {
            if (temp == null) {

                return;
            }
            System.out.println(temp.getData() + "->" + temp.getNext());
            temp = temp.getNext();
        }
    }

    public void reverseDisplay() {
        prev = null;
        current = head;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    //Recursion

    public void reverseLL(Node head) {
        
        if (head.getNext() == null) {
        } else {
            //temp = temp.getNext();
            reverseLL(head.getNext());
        }
        System.out.println(head.getData()+" ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        reverseLL ll = new reverseLL();
        ll.insertatLast(1);
        ll.insertatLast(2);
        ll.insertatLast(3);
        ll.insertatLast(4);
        ll.insertatLast(5);
        //ll.reverseDisplay();
        ll.display();
        ll.reverseLL(ll.head);
    }

}
