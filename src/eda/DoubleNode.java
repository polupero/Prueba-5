package eda;

/**
 *
 * @author Hagen
 */
public class DoubleNode<T> {

    private T elemento;
    private DoubleNode<T> next, prev;

    public DoubleNode() {
        clear();
    }

    public void clear() {
        elemento = null;
        prev = null;
        next = null;
    }

    public DoubleNode(T elemento) {
        this.elemento = elemento;
        next = null;
        prev = null;
    }

    public DoubleNode(T elemento, DoubleNode<T> next, DoubleNode<T> prev) {
        this.elemento = elemento;
        this.next = next;
        this.prev = prev;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

}
