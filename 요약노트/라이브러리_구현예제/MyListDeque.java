import java.util.*;

public class MyListDeque<E> {
    private int size = 0;
    private Node<E> firstNode = null;
    private Node<E> lastNode = null;

    public static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;
        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(null, element, firstNode);
        if (size == 0) lastNode = newNode;
        else firstNode.prev = newNode;
        firstNode = newNode;
        size++;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(lastNode, element, null);
        if (size == 0) firstNode = newNode;
        else lastNode.next = newNode;
        lastNode = newNode;
        size++;
    }

    public E removeFirst() {
        if (size == 0)
            throw new NoSuchElementException("Deque is empty.");

        E item = firstNode.item;
        firstNode = firstNode.next;
        if (firstNode == null)
            lastNode = null;
        size--;
        return item;
    }

    public E removeLast() {
        if (size == 0)
            throw new NoSuchElementException("Deque is empty.");

        E item = lastNode.item;
        lastNode = lastNode.prev;
        if (lastNode == null)
            firstNode = null;
        size--;
        return item;
    }

    public E getFirst() {
        if (size == 0)
            throw new NoSuchElementException("Deque is empty.");
        return firstNode.item;
    }

    public E getLast() {
        if (size == 0)
            throw new NoSuchElementException("Deque is empty.");
        return lastNode.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main (String[] args) {
        MyListDeque<Integer> q = new MyListDeque<>();

        // 덱의 가장 앞/뒤에 원소 추가: O(1)
        q.addFirst(1);                      // [1]
        q.addFirst(2);                      // [2, 1]
        q.addLast(3);                       // [2, 1, 3]
        q.addLast(4);                       // [2, 1, 3, 4]

        // 덱의 가장 앞/뒤 원소 삭제: O(1)
        q.removeFirst();                    // [1, 3, 4]
        q.removeLast();                     // [1, 3]

        // 덱의 가장 앞/뒤 원소 조회: O(1)
        System.out.println(q.getFirst());   // 1
        System.out.println(q.getLast());    // 3
    }
}
