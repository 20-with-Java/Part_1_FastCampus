import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        long l = 1;
        long r = (long)N * N;
        long ans = -1;
        while (l <= r) {
            long m = (l + r) / 2;
            long count = 0;
            for (int i = 1; i <= N; i++)
                count += Math.min(m / i, N);
            if (count >= K) {
                ans = m;
                r = m - 1;
            }
            else l = m + 1;
        }
        System.out.println(ans);
    }
}
