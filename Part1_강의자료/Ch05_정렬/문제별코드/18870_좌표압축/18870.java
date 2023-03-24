import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[][] xs = new int[N][2];
        for (int i = 0; i < N; i++) {
            xs[i][0] = Integer.parseInt(inputs[i]);
            xs[i][1] = i;
        }

        Arrays.sort(xs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] ans = new int[N];
        int idx = 0;
        ans[xs[0][1]] = idx;
        for (int i = 1; i < N; i++) {
            if (xs[i][0] != xs[i - 1][0]) idx++;
            ans[xs[i][1]] = idx;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++)
            bw.write(ans[i] + " ");
        bw.flush();
    }
}
