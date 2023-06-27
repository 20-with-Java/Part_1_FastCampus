import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();

        int[] accRemainCount = new int[M];
        int currentRemain = 0;
        accRemainCount[currentRemain]++;
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            currentRemain = (currentRemain + arr[i]) % M;
            ans += accRemainCount[currentRemain];
            accRemainCount[currentRemain]++;
        }
        System.out.println(ans);
    }
}
