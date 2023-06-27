import java.util.*;

class Main
{
    static long howManyPass(long givenTime, int[] timePerPass) {
        long count = 0;
        for (int time : timePerPass)
            count += givenTime / time;
        return count;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] timePerPass = new int[N];
        for (int i = 0; i < N; i++)
            timePerPass[i] = sc.nextInt();

        long ans = 0;
        long l = 1;
        long r = (long)Arrays.stream(timePerPass).min().getAsInt() * M;
        while (l <= r) {
            long m = (l + r) / 2;
            if (howManyPass(m, timePerPass) >= M) {
                ans = m;
                r = m - 1;
            }
            else l = m + 1;
        }
        System.out.println(ans);
    }
}
