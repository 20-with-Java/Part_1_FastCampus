import java.util.Scanner;

class Main
{
    public static boolean isPossible(int[] lengths, int videoLength, int videoCount) {
        int currentLength = 0;
        int currentCount = 1;
        for (int len : lengths) {
            if (len > videoLength) return false;
            if (currentLength + len > videoLength) {
                if (++currentCount > videoCount) return false;
                currentLength = 0;
            }
            currentLength += len;
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] lengths = new int[N];
        for (int i = 0; i < N; i++)
            lengths[i] = sc.nextInt();

        int l = 1, r = N * 10000, ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(lengths, m, M)) {
                ans = m;
                r = m - 1;
            }
            else l = m + 1;
        }
        System.out.println(ans);
    }
}
