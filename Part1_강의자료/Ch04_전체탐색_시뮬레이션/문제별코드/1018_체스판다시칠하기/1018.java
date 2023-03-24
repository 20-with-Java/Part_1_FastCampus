import java.util.Scanner;

class Main
{
    private static int countDifferent(char[][] map, int starRow, int startColumn, String pattern) {
        int cnt = 0;
        for (int i = starRow; i < starRow + 8; i++)
            for (int j = startColumn; j < startColumn + 8; j++)
                if (map[i][j] != pattern.charAt((i + j) % 2))
                    cnt++;
        return cnt;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = sc.next();
            map[i] = line.toCharArray();
        }

        int ans = N * M;
        for (int i = 0; i <= N - 8; i++)
            for (int j = 0; j <= M - 8; j++) {
                int countBW = countDifferent(map, i, j, "BW");
                int countWB = countDifferent(map, i, j,"WB");
                ans = Math.min(ans, Math.min(countBW, countWB));
            }
        System.out.println(ans);
    }
}
