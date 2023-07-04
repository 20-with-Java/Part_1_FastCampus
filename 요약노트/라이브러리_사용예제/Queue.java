import java.util.*;

class Main
{
    public static void main (String[] args) {
        // FIFO 특성을 지닌 큐의 가장 기본적인 구현체인 LinkedList를 사용합니다.
        Queue<Integer> q = new LinkedList<>();

        // 큐의 가장 뒤에 원소 추가: O(1)
        // 큐에 공간이 부족할 때 Exception이 발생하는 add와 false를 반환하는 offer가 제공됩니다.
        q.offer(1);                 // [1]
        q.offer(2);                 // [1, 2]
        q.add(3);                   // [1, 2, 3]
        q.add(4);                   // [1, 2, 3, 4]

        // 큐의 가장 앞 원소 삭제: O(1)
        // 큐가 비었을 때 Exception이 발생하는 remove와 null을 반환하는 poll이 제공됩니다.
        q.poll();                   // [2, 3, 4]
        q.remove();                 // [3, 4]

        // 큐의 가장 앞 원소 조회: O(1)
        // 큐가 비었을 때 Exception이 발생하는 element와 null을 반환하는 peek이 제공됩니다.
        System.out.println(q.peek());       // 3
        System.out.println(q.element());    // 3
    }
}
