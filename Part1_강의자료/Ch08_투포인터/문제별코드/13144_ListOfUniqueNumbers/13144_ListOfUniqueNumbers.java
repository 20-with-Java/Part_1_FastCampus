import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        boolean[] appeared = new boolean[100001];
        long ansCount = 0;
        int nextIndex = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N) {
                if (appeared[arr[nextIndex]]) break;
                appeared[arr[nextIndex++]] = true;
            }
            ansCount += nextIndex - i;
            appeared[arr[i]] = false;
        }
        System.out.println(ansCount);
    }
}
