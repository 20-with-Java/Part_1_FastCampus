public class MyArrayDeque<E> {
    private Object[] data;
    private int firstIndex;
    private int lastIndex;
    private int capacity;
    private int size;

    public MyArrayDeque(int maxCapacity) {
        this.capacity = maxCapacity;
        data = new Object[capacity];
        firstIndex = 0;
        lastIndex = 0;
        size = 0;
    }

    public boolean addFirst(E element) {
        if (size == capacity) return false;

        firstIndex = (firstIndex - 1 + capacity) % capacity;
        data[firstIndex] = element;
        size++;
        return true;
    }

    public boolean addLast(E element) {
        if (size == capacity) return false;

        data[lastIndex] = element;
        lastIndex = (lastIndex + 1) % capacity;
        size++;
        return true;
    }

    public E removeFirst() {
        if (size == 0) return null;

        E value = (E) data[firstIndex];
        data[firstIndex] = null;
        firstIndex = (firstIndex + 1) % capacity;
        size--;
        return value;
    }

    public E removeLast() {
        if (size == 0) return null;

        lastIndex = (lastIndex - 1 + capacity) % capacity;
        E value = (E) data[lastIndex];
        data[lastIndex] = null;
        size--;
        return value;
    }

    public E getFirst() {
        if (size == 0) return null;
        return (E) data[firstIndex];
    }

    public E getLast() {
        if (size == 0) return null;
        return (E) data[(lastIndex - 1 + capacity) % capacity];
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
        MyArrayDeque<Integer> q = new MyArrayDeque<>(10);

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
