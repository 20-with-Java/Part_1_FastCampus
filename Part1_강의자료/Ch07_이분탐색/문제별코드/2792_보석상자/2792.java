import java.util.Scanner;

class Main
{
    public static boolean isPossible(int[] colorAmounts, int maxDivideCount, int totalStudentCount) {
        int receivedStudentCount = 0;
        for (int colorAmount : colorAmounts)
            receivedStudentCount += (colorAmount + maxDivideCount - 1) / maxDivideCount;
        return receivedStudentCount <= totalStudentCount;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] colorAmounts = new int[M];
        for (int i = 0; i < M; i++)
            colorAmounts[i] = sc.nextInt();

        int l = 1, r = 1000000000, ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(colorAmounts, m, N)) {
                ans = m;
                r = m - 1;
            }
            else l = m + 1;
        }
        System.out.println(ans);
    }
}
