package eda;

import eda.exceptions.ElementNotFoundException;
import eda.exceptions.EmptyCollectionException;

/**
 * Uso de nodos centinelas.
 *
 * @author Hagen
 */
public class LinkedList<T> {

    DoubleNode<T> head, tail;
    int count;

    public LinkedList() {
        clear();
    }

    public void clear() {
        count = 0;
        DoubleNode<T> head = new DoubleNode<>();
        DoubleNode<T> tail = new DoubleNode<>();
        head.setNext(tail);
        tail.setPrev(head);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            return toString(head.getNext(), sb);
        }
    }

    protected String toString(DoubleNode<T> current, StringBuilder sb) {
        if (current.equals(tail)) {
            return sb.toString();
        } else {
            sb.append(current.getElemento());
            return toString(current.getNext(), sb);
        }
    }

    public String toStringInverso() {
        if (isEmpty()) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            return toStringInverso(tail.getPrev(), sb);
        }
    }
    
    protected String toStringInverso(DoubleNode<T> current, StringBuilder sb){
        if (current.equals(head)) {
            return sb.toString();
        } else {
            sb.append(current.getElemento());
            return toString(current.getPrev(), sb);
        }
    }

    protected DoubleNode<T> find(T element) {
        if (isEmpty()) {
            return null;
        } else {
            return find(element, head.getNext());
        }
    }

    protected DoubleNode<T> find(T element, DoubleNode<T> current) {
        if (current.equals(tail)) {
            return null;
        }
        if (current.getElemento().equals(element)) {
            return current;
        } else {
            return find(element, current.getNext());
        }
    }

    public boolean contains(T element) {
        return find(element) != null;
    }

    protected T delete(DoubleNode<T> nodo) {
        nodo.getNext().setPrev(nodo.getPrev());
        nodo.getPrev().setNext(nodo.getNext());
        count--;
        return nodo.getElemento();
    }

    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List");
        }
        if (find(element) == null) {
            throw new ElementNotFoundException((String) element);
        }
        return delete(find(element));
    }

    protected void insert(T element, DoubleNode<T> anterior, DoubleNode<T> siguiente) {
        DoubleNode<T> nuevo = new DoubleNode(element);
        anterior.setNext(nuevo);
        siguiente.setPrev(nuevo);
        nuevo.setPrev(anterior);
        nuevo.setNext(siguiente);
        count++;
    }

    public void add(T element) {
        if (isEmpty()) {
            insert(element, head, tail);
        } else {
            insert(element, tail.getPrev(), tail);
        }
    }

}
