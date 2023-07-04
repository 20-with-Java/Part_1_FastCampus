import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MyQueue<Integer> q = new MyQueue<>();
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push")) {
                q.enqueue(Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("pop")) {
                bw.write(q.isEmpty() ? "-1\n" : q.dequeue() + "\n");
            }
            else if (cmd[0].equals("size")) {
                bw.write(q.size() + "\n");
            }
            else if (cmd[0].equals("empty")) {
                bw.write(q.isEmpty() ? "1\n" : "0\n");
            }
            else if (cmd[0].equals("front")) {
                bw.write(q.isEmpty() ? "-1\n" : q.getFront() + "\n");
            }
            else if (cmd[0].equals("back")) {
                bw.write(q.isEmpty() ? "-1\n" : q.getRear() + "\n");
            }
        }
        bw.flush();
    }
}

class MyQueue<E> {
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
        return frontNode.item;
    }

    public E getRear() {
        return rearNode.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
