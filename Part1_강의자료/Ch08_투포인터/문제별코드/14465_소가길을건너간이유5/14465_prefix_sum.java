import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int B = sc.nextInt();
        boolean[] isBroken = new boolean[N + 1];
        while (B-- > 0) {
            int idx = sc.nextInt();
            isBroken[idx] = true;
        }

        int[] accBroken = new int[N + 1];
        for (int i = 1; i <= N; i++)
            accBroken[i] = accBroken[i - 1] + (isBroken[i] ? 1 : 0);

        int ans = K;
        for (int i = 1; i <= N - K + 1; i++)
            ans = Math.min(ans, accBroken[i + K - 1] - accBroken[i - 1]);
        System.out.println(ans);
    }
}
