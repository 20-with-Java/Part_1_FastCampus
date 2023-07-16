import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();

        Deque<Integer>[] pushed = new ArrayDeque[7];
        for (int i = 1; i <= 6; i++)
            pushed[i] = new ArrayDeque<>();

        int moveCount = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int fret = sc.nextInt();

            while (!pushed[num].isEmpty()) {
                if (pushed[num].peekLast() > fret) {
                    pushed[num].pollLast();
                    moveCount++;
                }
                else break;
            }
            if (!pushed[num].isEmpty() && pushed[num].peekLast() == fret)
                continue;

            pushed[num].offerLast(fret);
            moveCount++;
        }
        System.out.println(moveCount);
    }
}
