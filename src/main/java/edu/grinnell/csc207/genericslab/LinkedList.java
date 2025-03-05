/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.genericslab;

/**
 *
 * @author liannie
 */
public class LinkedList<T> {
    public class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    /**
     * Constructs a new, empty linked list.
     */
    public LinkedList() {
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        if (first == null) {
            first = new Node(value, null);
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node<T> cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node<T> cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = (T) first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node<T> cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }
    /**
     * Inserts the specified separator between every element of this list.
     * 
     * @param sep the separator to intersperse between elements of this list
     */
    public void intersperse(T sep) {
        if (first == null) {
            return;
        }
        Node<T> current = first;
        while (current != null && current.next != null) {
            Node<T> sepNode = new Node<>(sep, current.next);
            current.next = sepNode;
            current = sepNode.next;
        }
    }
    /**
     * Returns the maximum element found in the list.
     * 
     * This method cannot be implemented for a generic type T unless T implements Comparable<T>.
     * Since our generic list does not restrict T to types that are comparable, there is no way
     * to determine the maximum element. Therefore, this method is unsupported.
     *
     * @return the maximum element in the list
     * @throws UnsupportedOperationException always, because the operation cannot be implemented
     */
    public T maximum() {
        throw new UnsupportedOperationException();
    }
    public String toString() {
        if (first == null) {
            return "[]";
        } else {
            String result = "[";
            Node<T> cur = first;
            while (cur.next != null) {
            result = result + cur.value + ", ";
                cur = cur.next;
            }
            result = result + cur.value + "]";
            return result;
        }
    }
    /**
    * This operation cannot be implemented because we don't know how to compare letter with integer or other parameter of different.
    */
    public void insertionSort(){
            throw new UnsupportedOperationException();
        }
    
}
