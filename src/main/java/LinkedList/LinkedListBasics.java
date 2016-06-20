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
public class LinkedListBasics {

    Node head;
    Node temp, prev;
    int size;

    public void insertatFirst(int data) {
        Node ins = new Node(data, null);
        ins.setNext(head);
        head = ins;
    }

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

    public void insertafter(int data, int insdata) {
        temp = head;
        while (temp.getData() != data) {
            temp = temp.getNext();
        }
        Node ins = new Node(insdata, null);
        ins.setNext(temp.getNext());
        temp.setNext(ins);
    }

    public void insertbefore(int data, int insdata) {
        temp = head;
        while (temp.getData() != data) {
            prev = temp;
            temp = temp.getNext();
        }
        Node ins = new Node(insdata, null);
        ins.setNext(prev.getNext());
        prev.setNext(ins);

        prev = null;
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

    public void printList(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.getData()+" ");
            temp = temp.getNext();
        } while (temp != head);
        System.out.println("");
    }

    public void pop() {
        temp = head;
        head = head.getNext();

    }

    public void delete(int data) {
        temp = head;
        if (head.getData() == data) {
            head = head.getNext();
            return;
        }
        while (temp != null && temp.getData() != data) {
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(temp.getNext());
        temp = null;
    }

    public void sortAscending() {

    }
}
