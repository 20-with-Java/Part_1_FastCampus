import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MyDeque<Integer> q = new MyDeque<>();
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push_front")) {
                q.addFirst(Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("push_back")) {
                q.addLast(Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("pop_front")) {
                bw.write(q.isEmpty() ? "-1\n" : q.removeFirst() + "\n");
            }
            else if (cmd[0].equals("pop_back")) {
                bw.write(q.isEmpty() ? "-1\n" : q.removeLast() + "\n");
            }
            else if (cmd[0].equals("size")) {
                bw.write(q.size() + "\n");
            }
            else if (cmd[0].equals("empty")) {
                bw.write(q.isEmpty() ? "1\n" : "0\n");
            }
            else if (cmd[0].equals("front")) {
                bw.write(q.isEmpty() ? "-1\n" : q.getFirst() + "\n");
            }
            else if (cmd[0].equals("back")) {
                bw.write(q.isEmpty() ? "-1\n" : q.getLast() + "\n");
            }
        }
        bw.flush();
    }
}

class MyDeque<E> {
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
}
