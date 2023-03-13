import java.util.Arrays;
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        char[] ans = new char[N];
        Arrays.fill(ans, '?');

        int curIndex = 0;
        while (K-- > 0) {
            int backStep = sc.nextInt();
            char backAlphabet = sc.next().charAt(0);
            int nextIndex = ((curIndex - backStep) % N + N) % N;
            if (ans[nextIndex] == '?') ans[nextIndex] = backAlphabet;
            else if (ans[nextIndex] != backAlphabet) {
                System.out.println("!");
                return ;
            }
            curIndex = nextIndex;
        }

        boolean[] chk = new boolean[26];
        for (int i = 0; i < N; i++) {
            if (ans[i] == '?') continue;
            if (chk[ans[i] - 'A']) {
                System.out.println("!");
                return ;
            }
            chk[ans[i] - 'A'] = true;
        }

        for (int i = 0; i < N; i++)
            System.out.print(ans[(curIndex + i) % N]);
        System.out.println();
    }
}
