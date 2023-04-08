import java.util.Scanner;

class Main
{
    static int calcTotalBudget(int[] budgets, int budgetLimit) {
        int sum = 0;
        for (int budget : budgets)
            sum += Math.min(budget, budgetLimit);
        return sum;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] budgets = new int[N];
        int maxBudget = 0;
        for (int i = 0; i < N; i++) {
            budgets[i] = sc.nextInt();
            maxBudget = Math.max(maxBudget, budgets[i]);
        }
        int M = sc.nextInt();

        int l = 1, r = maxBudget, ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            int totalBudget = calcTotalBudget(budgets, m);
            if (totalBudget <= M) {
                ans = m;
                l = m + 1;
            }
            else r = m - 1;
        }
        System.out.println(ans);
    }
}
