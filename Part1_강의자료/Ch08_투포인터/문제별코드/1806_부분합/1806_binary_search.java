import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();

        long[] acc = new long[N + 1];
        for (int i = 1; i <= N; i++)
            acc[i] = acc[i - 1] + arr[i];

        int ansLength = N + 1;
        for (int i = 1; i <= N; i++) {
            int l = i, r = N;
            while (l <= r) {
                int m = (l + r) / 2;
                long sum = acc[m] - acc[i - 1];
                if (sum >= M) {
                    ansLength = Math.min(ansLength, m - i + 1);
                    r = m - 1;
                }
                else l = m + 1;
            }
        }

        if (ansLength > N) ansLength = 0;
        System.out.println(ansLength);
    }
}
