package models;

public class Node<T> {

    private T transaction;
    private Node<T> next;

    public Node(T transaction) {
        this.transaction = transaction;
    }

    public Node(T transaction, Node<T> next) {
        this.transaction = transaction;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{ Transaction=" + transaction + "}";
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getTransaction() {
        return transaction;
    }
}
