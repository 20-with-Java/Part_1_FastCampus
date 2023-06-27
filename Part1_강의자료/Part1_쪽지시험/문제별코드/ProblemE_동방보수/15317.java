import java.util.*;

class Main
{
    static long calcNeedAmount(int[] cost, int[] budget, int assignCount) {
        long needAmount = 0;
        for (int i = 0; i < assignCount; i++)
            needAmount += Math.max(cost[i] - budget[budget.length - assignCount + i], 0);
        return needAmount;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();

        int[] cost = new int[N];
        for (int i = 0; i < N; i++)
            cost[i] = sc.nextInt();

        int[] budget = new int[M];
        for (int i = 0; i < M; i++)
            budget[i] = sc.nextInt();

        Arrays.sort(cost);
        Arrays.sort(budget);

        int l = 0, r = Math.min(N, M), ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (calcNeedAmount(cost, budget, m) <= X) {
                ans = m;
                l = m + 1;
            }
            else r = m - 1;
        }
        System.out.println(ans);
    }
}
