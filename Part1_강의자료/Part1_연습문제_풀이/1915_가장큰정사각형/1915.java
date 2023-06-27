import java.util.*;

class Main
{
    static boolean isExist(int[][] acc, int len) {
        int N = acc.length - 1;
        int M = acc[0].length - 1;
        for (int i = 1; i <= N - len + 1; i++)
            for (int j = 1; j <= M - len + 1; j++) {
                int count = acc[i + len - 1][j + len - 1] - acc[i + len - 1][j - 1] - acc[i - 1][j + len - 1] + acc[i - 1][j - 1];
                if (count == len * len) return true;
            }
        return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] acc = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String row = sc.next();
            for (int j = 1; j <= M; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1];
                if (row.charAt(j - 1) == '1') acc[i][j]++;
            }
        }

        int l = 1;
        int r = Math.min(N, M);
        int ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isExist(acc, m)) {
                ans = m * m;
                l = m + 1;
            }
            else r = m - 1;
        }
        System.out.println(ans);
    }
}
