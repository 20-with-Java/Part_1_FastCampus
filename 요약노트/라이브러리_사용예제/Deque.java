import java.util.*;

class Main
{
    public static void main (String[] args) {
        Deque<Integer> q = new LinkedList<>();

        // 덱의 가장 앞/뒤에 원소 추가: O(1)
        // 덱에 공간이 부족할 때 Exception이 발생하는 add와 false를 반환하는 offer가 제공됩니다.
        q.offerFirst(1);                    // [1]
        q.addFirst(2);                      // [2, 1]
        q.offerLast(3);                     // [2, 1, 3]
        q.addLast(4);                       // [2, 1, 3, 4]

        // 덱의 가장 앞/뒤 원소 삭제: O(1)
        // 덱이 비었을 때 Exception이 발생하는 remove와 null을 반환하는 poll이 제공됩니다.
        q.pollFirst();                      // [1, 3, 4]
        q.removeLast();                     // [1, 3]

        // 덱의 가장 앞/뒤 원소 조회: O(1)
        // 덱이 비었을 때 Exception이 발생하는 get과 null을 반환하는 peek이 제공됩니다.
        System.out.println(q.peekFirst());  // 1
        System.out.println(q.getLast());    // 3
    }
}
