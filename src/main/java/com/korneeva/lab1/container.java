package com.korneeva.lab1;

import java.util.Scanner;
/**
 * Class which is describing a linked list
 * @author 12kvv 
 * @param <T> is a parameter overload
 */
public class container <T> {
	
	/** List head */
    private Node head;
    
    /** List size */
    private static int size;
    
    /** Constructor for an object of the container class */
    public container()
    {
    	this.head = null;
        size = 0;
    }
    
    /**
     * Class which is describing the structure of a linked list node
     * @param <T> is a parameter overload
     */
    public class Node <T> {

        /** Value field */
        private T value;

        /** Link to the next item in the list */
        private Node <T> next;

        /** Constructor for an object of the Node class */
        public Node() {
            this.next = null;
        }

        /**
         * Getter-method for node value
         * @return node value
         */
        public T getValue() {
            return value;
        }

        /** Setter-method for node value 
         * @param val the value of the element to be set
         */
        public void setValue(T val) {
            this.value = val;
        }

        /**
         * Getter-method for link to next node
         * @return link to next node
         */
        public Node<T> getNext() {
            return next;
        }

        /** Setter-method for link to the next node 
         * @param obj the value of the link to the next node
         */
        public void setNext(Node<T> obj) {
            this.next = obj;
        }
    }
    
    /**
     * Checking a list for emptiness
     * @return true if the list is empty, false otherwise
     */
    public boolean is_empty() {
        return (head == null);
    }
    
    /**
     * Getting list size
     * @return list size
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Adding node to the beginning of the list
     * @param val the value of the element to be added
     */
    public void addToHead(T val) {
        Node p = new Node();
        p.setValue(val);
        p.setNext(head);
        head = p;
        size++;
    }

    /**
     * Adding node to the end of the list
     * @param val the value of the element to be added
     */
    public void addToTail(T val) {
    	Node p = new Node();
    	Node q = new Node();
        p.setValue(val);
        q = findPosition(size + 1);
        q.setNext(p);
        size++;
        q = null;
    }
    
    /**
     * Adding node to the list at a specified position
     * @param val the value of the element to be added
     * @param index position of the element to be added
     */
    public void addByIndex(T val, int index) {
    	Node p = new Node();
    	Node q = new Node();
        q = findPosition(index);
        p.setNext(q.getNext());
        q.setNext(p);
        p.setValue(val);
        size++;
    }
    
    /**
     * Adding node to a list by value
     * @param val the value of the element to be added
     * @return true on successful insert, false otherwise
     */
    public boolean addElem(T val) {
        if (is_empty()) addToHead(val);
        else addToTail(val);
        return true;
    }
    
    /**
     * Position search
     * @param n position
     * @return obj the node that comes after the specified position
     */
    public Node findPosition(int n) {
    	Node obj = new Node();
        obj = head;
        for (int i = 0; i < n - 2; i++)
            obj = obj.getNext();
        return obj;
    }
    
    /** Removing node from the beginning of the list */
    public void deleteFromHead() {
        Node p = new Node();
        p = head;
        head = head.getNext();
        p = null;
        size--;
        if (size == 0) head = null;
    }

    /** Removing node from the end of the list
     * @param indexOfLastOne position of the last element
     */
    public void deleteFromTail(int indexOfLastOne) {
    	Node p = new Node();
        p = findPosition(indexOfLastOne);
        p.setNext(null);
        p = null;
        size--;
    }
    
    /** Removing an element from a specified position
     * @param index position
     */
    public void deleteByIndex(int index) {
        Node p = new Node();
        Node q = new Node();
        q = findPosition(index);
        p = q.getNext().getNext();
        q.setNext(p);
        p = null;
        q = null;
        size--;
    }

    /** Removing node from the list
     * @param n position
     * @return true on successful erase, false otherwise
     */
    public boolean deleteElem(int n) {
        if (is_empty()) {
            System.out.println("The list is empty.");
            return false;
        }
        else if (n == 1) {
            deleteFromHead();
            return true;
        }
        else if (n == size) {
            deleteFromTail(n);
            return true;
        }
        else if (n >= 2 && n < size) {
            deleteByIndex(n);
            return true;
        }
        else return false;
    }


    /** Retrieving node from a list
     * @param n position
     * @return the value of the element at the position n
     */
    public Node getElem(int n) {
        if (n < 1 || n > size) {
            System.out.println("Error: out of range.");
            return null;
        }
        else if (n == 1) {
            System.out.println("At position " + n + " is the element: " + head.getValue());
            return head;
        }
        else {
        	Node p = new Node();
            p = findPosition(n + 1);
            System.out.println("At position " + n + " is the element: " + p.getValue());
            return p;
        }
    }
}
