import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] acc = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + sc.nextInt();

        int ans = 0;
        Map<Integer, Integer>[][] ltVertex = new Map[N + 1][N + 1];
        Map<Integer, Integer>[][] rtVertex = new Map[N + 1][N + 1];
        Map<Integer, Integer>[][] lbVertex = new Map[N + 1][N + 1];
        Map<Integer, Integer>[][] rbVertex = new Map[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) {
                ltVertex[i][j] = new HashMap<>();
                rtVertex[i][j] = new HashMap<>();
                lbVertex[i][j] = new HashMap<>();
                rbVertex[i][j] = new HashMap<>();
            }

        for (int r1 = 1; r1 <= N; r1++)
            for (int c1 = 1; c1 <= N; c1++)
                for (int r2 = r1; r2 <= N; r2++)
                    for (int c2 = c1; c2 <= N; c2++) {
                        int score = acc[r2][c2] - acc[r1 - 1][c2] - acc[r2][c1 - 1] + acc[r1 - 1][c1 - 1];
                        ltVertex[r1][c1].put(score, ltVertex[r1][c1].getOrDefault(score, 0) + 1);
                        rtVertex[r1][c2].put(score, rtVertex[r1][c2].getOrDefault(score, 0) + 1);
                        lbVertex[r2][c1].put(score, lbVertex[r2][c1].getOrDefault(score, 0) + 1);
                        rbVertex[r2][c2].put(score, rbVertex[r2][c2].getOrDefault(score, 0) + 1);
                    }

        for (int r = 1; r < N; r++)
            for (int c = 1; c < N; c++)
                for (Map.Entry<Integer, Integer> entry : rbVertex[r][c].entrySet()) {
                    int score = entry.getKey();
                    int scoreCount = entry.getValue();
                    ans += scoreCount * ltVertex[r + 1][c + 1].getOrDefault(score, 0);
                }

        for (int r = 1; r < N; r++)
            for (int c = 2; c <= N; c++)
                for (Map.Entry<Integer, Integer> entry : lbVertex[r][c].entrySet()) {
                    int score = entry.getKey();
                    int scoreCount = entry.getValue();
                    ans += scoreCount * rtVertex[r + 1][c - 1].getOrDefault(score, 0);
                }

        System.out.println(ans);
    }
}
