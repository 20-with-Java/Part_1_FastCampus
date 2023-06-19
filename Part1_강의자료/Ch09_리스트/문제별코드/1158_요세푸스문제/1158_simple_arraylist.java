import java.util.*;
import java.util.stream.Collectors;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        SimpleArrayList<Integer> list = new SimpleArrayList<>(N);
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

class SimpleArrayList<E> {
    private int size = 0;
    private Object[] data;

    public SimpleArrayList(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    public void add(E element) {
        if (size == data.length)
            growCapacity();
        data[size++] = element;
    }

    private void growCapacity() {
        int newCapacity = data.length + (data.length >> 1);
        data = Arrays.copyOf(data, newCapacity);
    }

    public E remove(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);
        E deletedItem = (E)data[idx];
        int copyLength = data.length - idx - 1;
        System.arraycopy(data, idx + 1, data, idx, copyLength);
        size--;
        return deletedItem;
    }

    public int size() {
        return size;
    }
}
