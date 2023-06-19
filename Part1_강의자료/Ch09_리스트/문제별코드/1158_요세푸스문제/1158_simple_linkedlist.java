import java.util.*;
import java.util.stream.Collectors;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for (int i = 1; i <= N; i++)
            list.add(i);

        int[] ans = new int[N];
        int pastIdx = 0;
        for (int i = 0; i < N; i++) {
            int targetIdx = (pastIdx + K - 1) % list.size();
            ans[i] = list.remove(targetIdx);
            pastIdx = targetIdx;
        }

        System.out.println("<" + Arrays.stream(ans)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")) + ">");
    }
}

class SimpleLinkedList<E> {
    private int size = 0;
    private Node<E> firstNode = null;
    private Node<E> lastNode = null;

    public static class Node<E> {
        E item;
        Node<E> next;
        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (size == 0) firstNode = newNode;
        else lastNode.next = newNode;
        lastNode = newNode;
        size++;
    }

    public E remove(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);

        Node<E> prevNode = null;
        Node<E> targetNode = firstNode;
        for (int i = 0; i < idx; i++) {
            prevNode = targetNode;
            targetNode = targetNode.next;
        }

        if (prevNode == null)
            firstNode = firstNode.next;
        else {
            prevNode.next = targetNode.next;
            if (prevNode.next == null)
                lastNode = prevNode;
        }
        size--;
        return targetNode.item;
    }

    public int size() {
        return size;
    }
}
