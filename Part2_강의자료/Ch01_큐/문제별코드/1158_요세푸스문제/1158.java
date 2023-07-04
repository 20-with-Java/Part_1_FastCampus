import java.util.*;
import java.util.stream.Collectors;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            q.add(i);

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < K; j++)
                q.add(q.poll());
            ans[i] = q.poll();
        }

        System.out.print("<" + Arrays.stream(ans)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")) + ">");
    }
}
