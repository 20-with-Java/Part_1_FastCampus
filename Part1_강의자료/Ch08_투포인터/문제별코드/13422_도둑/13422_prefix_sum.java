import java.util.Scanner;

class Main
{
    static int getRangeSum(int[] acc, int l, int r) {
        if (l <= r) return acc[r] - acc[l - 1];
        return acc[acc.length - 1] - acc[l - 1] + acc[r];
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[] money = new int[N + 1];
            for (int i = 1; i <= N; i++)
                money[i] = sc.nextInt();

            int[] accMoney = new int[N + 1];
            for (int i = 1; i <= N; i++)
                accMoney[i] = accMoney[i - 1] + money[i];

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (getRangeSum(accMoney, i, (i + M - 2) % N + 1) < K)
                    ans++;
            }
            if (N == M) ans = Math.min(1, ans);
            System.out.println(ans);
        }
    }
}
