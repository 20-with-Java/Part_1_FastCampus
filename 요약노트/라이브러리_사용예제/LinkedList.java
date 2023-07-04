import java.util.*;

class Main
{
    public static void main (String[] args) {
        List<Integer> list = new LinkedList<>();
        // 굳이 다형성을 사용할 필요가 없다면 아래와 같이 인스턴스를 만들어
        // LinkedList의 추가적인 메서드인 addFirst/Last 등을 사용할 수 있습니다.
        // LinkedList<Integer> list = new LinkedList<>();

        // LinkedList의 add: O(1)
        list.add(1);                // [1]
        list.add(2);                // [1, 2]
        list.add(3);                // [1, 2, 3]
        list.add(4);                // [1, 2, 3, 4]

        // LinkedList의 위치를 지정하는 add(insert): O(N)
        list.add(0, 5);             // [5, 1, 2, 3, 4]
        list.add(list.size(), 6);   // [5, 1, 2, 3, 4, 6]
        list.add(3, 7);             // [5, 1, 2, 7, 3, 4, 6]

        // LinkedList의 특정 위치값에 대한 set: O(N)
        list.set(2, -1);            // [5, 1, -1, 7, 3, 4, 6]
        System.out.println(list);

        // LinkedList의 특정 위치값에 대한 get: O(N)
        System.out.printf("index: %d, value: %d\n", 4, list.get(4));

        // LinkedList의 원소에 순차적으로 접근한다면 Iterator를 사용하는 것이 더 효율적입니다.
        // ListIterator는 내부적으로 next 노드를 가리키고 있어 이를 통해 앞/뒤로 이동할 수 있습니다.
        ListIterator<Integer> it = list.listIterator();
        // ListIterator 생성 시 아래와 같이 [0:list.size()] 범위에서 시작 위치를 지정할 수도 있습니다.
        // ListIterator<Integer> it = list.listIterator(3);

        // ListIterator를 3칸 뒤로 이동 후 상태를 확인하는 예제입니다.
        // 현재 Iterator: [^5, 1, -1, 7, 3, 4, 6]
        for (int i = 0; i < 3; i++)
            if (it.hasNext())
                it.next();
        // 현재 Iterator: [5, 1, -1,^ 7, 3, 4, 6]

        // ListIterator의 prev/next를 확인해 생각한 위치가 맞는지 확인할 수 있습니다.
        // ListIterator는 prev/next에 대한 단순 접근자를 제공하지 않기 때문에
        // previous(), next()를 통해 실제 이동 후 반환 된 값을 사용해야 합니다.
        int itIndex = it.nextIndex();           //  3 , [5, 1, -1,^ 7, 3, 4, 6]
        int prevValue = it.previous();          // -1 , [5, 1,^ -1, 7, 3, 4, 6]
        it.next();                              // 원복, [5, 1, -1,^ 7, 3, 4, 6]
        int nextValue = it.next();              //  7 , [5, 1, -1, 7,^ 3, 4, 6]
        it.previous();                          // 원복, [5, 1, -1,^ 7, 3, 4, 6]
        System.out.printf("position %d iterator's prev: %d, next: %d\n", itIndex, prevValue, nextValue);

        // ListIterator.set()은 iterator가 수행한 previous()와 next() 중 마지막으로 반환한 노드를 대상으로 합니다.
        // 마지막으로 반환된 노드는 previous()로 반환되었던 3번 노드(7)입니다.
        // LinkedList의 ListIterator를 통한 특정 노드 set: O(1)
        it.set(10);                             // [5, 1, -1,^ 10, 3, 4, 6]
        it.set(20);                             // [5, 1, -1,^ 20, 3, 4, 6]
        System.out.println(list);

        // ListIterator.remove() 역시 set()과 같이 마지막 반환되었던 노드를 대상으로 합니다.
        // 여전히 마지막으로 반환된 노드는 previous()로 지나온 3번 노드(20)입니다.
        // LinkedList의 ListIterator를 통한 특정 노드 remove: O(1)
        it.remove();                            // [5, 1, -1,^ 3, 4, 6]

        // 마지막으로 반환된 노드가 삭제되었으므로 다시 previous/next로 iterator를 이동하기 전에
        // it.set()이나 it.remove()를 사용하면 IllegalStateException이 발생합니다.
        // it.remove();                         // IllegalStateException
        it.next();                              // [5, 1, -1, 3,^ 4, 6]
        it.next();                              // [5, 1, -1, 3, 4,^ 6]

        // 마지막으로 next()를 통해 4번 노드(4)을 반환했으므로 set/remove는 해당 노드를 대상으로 동작합니다.
        it.remove();                            // [5, 1, -1, 3,^ 6]
        System.out.println(list);

        // ListIterator를 통한 이동 중에 노드를 삽입하고 싶다면 add()를 사용할 수 있습니다.
        // next 노드의 앞에 전달받은 값의 새로운 노드를 연결하며, 이때 set/remove를 위한 마지막 반환 노드 정보는 유실됩니다.
        // LinkedList의 ListIterator를 통한 노드 삽입 insert: O(1)
        it.previous();                          // [5, 1, -1,^ 3, 6]
        it.add(100);                            // [5, 1, -1,^ 100, 3, 6]
        // it.remove(), it.set()                // IllegalStateException
        System.out.println(list);

        // LinkedList의 특정 위치값에 대한 remove: O(N)
        list.remove(5);                         // [5, 1, -1, 100, 3]
        int size = list.size();                 // 5
        System.out.printf("Size: %d, %s\n", size, list);

        // Collections의 sort, binarySearch 등을 사용할 수 있습니다.
        // LinkedList의 get 복잡도로 인해 binarySearch와 같은 메서드는 비효율적일 수 있습니다.
        Collections.sort(list);                 // [-1, 1, 3, 5, 100]
        System.out.println(list);
    }
}
