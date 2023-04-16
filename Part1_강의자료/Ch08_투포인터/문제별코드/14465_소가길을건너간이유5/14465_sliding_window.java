import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int B = sc.nextInt();
        boolean[] isBroken = new boolean[N + 1];
        while (B-- > 0) {
            int idx = sc.nextInt();
            isBroken[idx] = true;
        }

        int currentBrokenCount = 0;
        for (int i = 1; i <= K; i++)
            if (isBroken[i]) currentBrokenCount++;

        int ans = currentBrokenCount;
        for (int i = 2; i <= N - K + 1; i++) {
            if (isBroken[i - 1]) currentBrokenCount--;
            if (isBroken[i + K - 1]) currentBrokenCount++;
            ans = Math.min(ans, currentBrokenCount);
        }
        System.out.println(ans);
    }
}
