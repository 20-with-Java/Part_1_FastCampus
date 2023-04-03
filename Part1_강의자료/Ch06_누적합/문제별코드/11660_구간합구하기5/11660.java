import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Main
{
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                arr[i][j] = sc.nextInt();

        int[][] acc = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + arr[i][j];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (M-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            bw.write(acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1] + "\n");
        }
        bw.flush();
    }
}
