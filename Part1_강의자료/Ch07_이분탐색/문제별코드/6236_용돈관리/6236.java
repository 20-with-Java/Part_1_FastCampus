import java.util.Scanner;

class Main
{
    static boolean isPossible(int[] useAmounts, int drawAmount, int maxDrawCount) {
        int drawCount = 1;
        int currentAmount = drawAmount;
        for (int useAmount : useAmounts) {
            if (useAmount > drawAmount) return false;
            if (currentAmount < useAmount) {
                if (drawCount == maxDrawCount) return false;
                drawCount++;
                currentAmount = drawAmount;
            }
            currentAmount -= useAmount;
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] useAmounts = new int[N];
        for (int i = 0; i < N; i++)
            useAmounts[i] = sc.nextInt();

        int l = 1, r = N * 10000, ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(useAmounts, m, M)) {
                ans = m;
                r = m - 1;
            }
            else l = m + 1;
        }
        System.out.println(ans);
    }
}
