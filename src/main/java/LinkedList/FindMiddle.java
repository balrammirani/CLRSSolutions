/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Balram
 */
public class FindMiddle {

    /**
     * @param args the command line arguments
     */
    public static void findMiddle(Node head) {
        Node temp = head;
        Node slowptr = head;
        Node fastptr = head;
        while (fastptr != null && fastptr.getNext() != null) {
            slowptr = slowptr.getNext();
            fastptr = fastptr.getNext().getNext();
        }
        System.out.println(slowptr.getData());
    }

    public static void main(String[] args) {
        LinkedListBasics ll = new LinkedListBasics();
        ll.insertatFirst(1);
        ll.insertafter(1, 2);
        ll.insertafter(2, 3);
        ll.insertafter(3, 4);
        ll.insertafter(4, 5);
      /*  ll.insertafter(5, 6);
        ll.insertafter(6, 7);
        ll.insertafter(7, 8);
        ll.insertafter(8, 9);
        ll.insertafter(9, 10);
*/
        ll.display();
        findMiddle(ll.head);

    }

}
