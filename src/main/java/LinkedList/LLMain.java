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
public class LLMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedListBasics ll=new LinkedListBasics();
        
        ll.insertatLast(5);
        ll.insertatLast(6);
        ll.insertatLast(8);
        ll.display();
        ll.insertafter(6,7);
        ll.display();
        ll.insertbefore(6, 2);
        ll.display();
        System.out.println("*********");
        ll.delete(5);
        ll.display();
        ll.insertatFirst(12);
        ll.insertatFirst(13);
        ll.insertatFirst(14);
        ll.display();
        ll.pop();
        ll.display();
        
        
    }
    
}
