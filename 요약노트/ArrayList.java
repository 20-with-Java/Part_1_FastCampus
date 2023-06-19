import java.util.*;

class Main
{
    public static void main (String[] args) {
        List<Integer> list = new ArrayList<>(4);
        // ArrayList는 initial capacity를 지정할 수 있습니다.
        // 지정하지 않는다면 default capacity만큼의 배열이 생성됩니다.

        // ArrayList의 add: O(1)
        list.add(1);        // [1]
        list.add(2);        // [1, 2]
        list.add(3);        // [1, 2, 3]
        list.add(4);        // [1, 2, 3, 4]
        // 현재 capacity를 넘게되면 내부적으로 증가시킨 배열로 값을 이동합니다.
        list.add(5);        // [1, 2, 3, 4, 5]

        // ArrayList의 특정 위치값에 대한 set: O(1)
        list.set(2, -1);    // [1, 2, -1, 4, 5]

        // ArrayList의 위치를 지정하는 add(insert): O(N)
        list.add(3, 10);    // [1, 2, -1, 10, 4, 5]
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            // ArrayList의 특정 위치값에 대한 get: O(1)
            // 특성상 Iterator보다 index접근이 자주 사용되는 편입니다.
            int num = list.get(i);
            System.out.printf("%d-th num: %d\n", i, num);
        }

        // ArrayList의 중간 원소 삭제: O(N)
        list.remove(1);             // [1, -1, 10, 4, 5]
        int size = list.size();     // 5
        System.out.printf("Size: %d\n", size);

        // Collections의 sort, binarySearch 등을 사용할 수 있습니다.
        Collections.sort(list);
        System.out.println(list);   // [-1, 1, 4, 5, 10]
    }
}
