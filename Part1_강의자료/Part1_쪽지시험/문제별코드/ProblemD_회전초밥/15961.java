import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D = sc.nextInt();
        int K = sc.nextInt();
        int C = sc.nextInt();

        int[] dish = new int[N];
        for (int i = 0; i < N; i++)
            dish[i] = sc.nextInt();

        int[] dishCount = new int[D + 1];
        int kind = 0;
        for (int i = 0; i < K - 1; i++)
            if (dishCount[dish[i]]++ == 0)
                kind++;

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (dishCount[dish[(i + K - 1) % N]]++ == 0)
                kind++;
            ans = Math.max(ans, kind + (dishCount[C] == 0 ? 1 : 0));
            if (--dishCount[dish[i]] == 0)
                kind--;
        }
        System.out.println(ans);
    }
}
