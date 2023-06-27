import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] cnt = new int[10];
        while (N > 0) {
            cnt[N % 10]++;
            N /= 10;
        }

        int ans = (cnt[6] + cnt[9] + 1) / 2;
        for (int i = 0; i < 9; i++)
            if (i != 6) ans = Math.max(ans, cnt[i]);
        System.out.println(ans);
    }
}
