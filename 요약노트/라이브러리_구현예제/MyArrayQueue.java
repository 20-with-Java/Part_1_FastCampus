public class MyArrayQueue<E> {
    private Object[] data;
    private int frontIndex;
    private int rearIndex;
    private int capacity;
    private int size;

    public MyArrayQueue(int maxCapacity) {
        this.capacity = maxCapacity;
        data = new Object[capacity];
        frontIndex = 0;
        rearIndex = -1;
        size = 0;
    }

    public boolean enqueue(E element) {
        if (size == capacity) return false;

        rearIndex = (rearIndex + 1) % capacity;
        data[rearIndex] = element;
        size++;
        return true;
    }

    public E dequeue() {
        if (size == 0) return null;

        E value = (E) data[frontIndex];
        data[frontIndex] = null;
        frontIndex = (frontIndex + 1) % capacity;
        size--;
        return value;
    }

    public E getFront() {
        if (size == 0) return null;
        return (E) data[frontIndex];
    }

    public E getRear() {
        if (size == 0) return null;
        return (E) data[rearIndex];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main (String[] args) {
        // 고정 길이 배열을 사용하는 형태의 구현체에서는 최대 용량을 지정해야합니다.
        MyArrayQueue<Integer> q = new MyArrayQueue<>(10);

        // 큐의 가장 뒤에 원소 추가: O(1)
        q.enqueue(1);               // [1            ...]
        q.enqueue(2);               // [1, 2         ...]
        q.enqueue(3);               // [1, 2, 3      ...]
        q.enqueue(4);               // [1, 2, 3, 4   ...]

        // 큐의 가장 앞 원소 삭제: O(1)
        q.dequeue();                // [   2, 3, 4   ...]
        q.dequeue();                // [      3, 4   ...]

        // 큐의 가장 앞/뒤 원소 조회: O(1)
        System.out.println(q.getFront());   // 3
        System.out.println(q.getRear());    // 4
    }
}
