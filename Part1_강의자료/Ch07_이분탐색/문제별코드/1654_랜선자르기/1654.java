import java.util.Scanner;

class Main
{
    static int calculateCount(int[] lengths, long cutLength) {
        int cnt = 0;
        for (int l : lengths)
            cnt += l / cutLength;
        return cnt;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] len = new int[K];
        for (int i = 0; i < K; i++)
            len[i] = sc.nextInt();

        long l = 1, r = (1L << 31) - 1, ans = -1;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (calculateCount(len, m) >= N) {
                ans = m;
                l = m + 1;
            }
            else r = m - 1;
        }
        System.out.println(ans);
    }
}
