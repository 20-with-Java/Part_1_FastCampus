import java.util.*;

public class MyListQueue<E> {
    private int size = 0;
    private Node<E> frontNode = null;
    private Node<E> rearNode = null;

    public static class Node<E> {
        E item;
        Node<E> next;
        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (size == 0) frontNode = newNode;
        else rearNode.next = newNode;
        rearNode = newNode;
        size++;
    }

    public E dequeue() {
        if (size == 0)
            throw new NoSuchElementException("Queue is empty.");

        E item = frontNode.item;
        frontNode = frontNode.next;
        if (frontNode == null)
            rearNode = null;
        size--;
        return item;
    }

    public E getFront() {
        if (size == 0)
            throw new NoSuchElementException("Queue is empty.");
        return frontNode.item;
    }

    public E getRear() {
        if (size == 0)
            throw new NoSuchElementException("Queue is empty.");
        return rearNode.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main (String[] args) {
        MyListQueue<Integer> q = new MyListQueue<>();

        // 큐의 가장 뒤에 원소 추가: O(1)
        q.enqueue(1);               // [1]
        q.enqueue(2);               // [1, 2]
        q.enqueue(3);               // [1, 2, 3]
        q.enqueue(4);               // [1, 2, 3, 4]

        // 큐의 가장 앞 원소 삭제: O(1)
        q.dequeue();                // [2, 3, 4]
        q.dequeue();                // [3, 4]

        // 큐의 가장 앞/뒤 원소 조회: O(1)
        System.out.println(q.getFront());   // 3
        System.out.println(q.getRear());    // 4
    }
}
