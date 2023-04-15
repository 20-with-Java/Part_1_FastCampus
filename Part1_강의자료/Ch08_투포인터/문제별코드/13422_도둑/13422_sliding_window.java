import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[] money = new int[N];
            for (int i = 0; i < N; i++)
                money[i] = sc.nextInt();

            int currentSum = 0;
            for (int i = 0; i < M; i++)
                currentSum += money[i];

            int ans = (currentSum < K ? 1 : 0);
            if (N != M) {
                for (int i = 1; i < N; i++) {
                    currentSum -= money[i - 1];
                    currentSum += money[(i + M - 1) % N];
                    if (currentSum < K) ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
