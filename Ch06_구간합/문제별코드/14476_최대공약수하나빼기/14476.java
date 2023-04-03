import java.util.*;

class Main
{
    static int calculateGCD(int a, int b) {
        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();

        int[] accLeft = new int[N + 1];
        int[] accRight = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            accLeft[i] = calculateGCD(accLeft[i - 1], arr[i]);
            accRight[N - i + 1] = calculateGCD(accRight[N - i + 2], arr[N - i + 1]);
        }

        int maxGCD = -1;
        int maxK = -1;
        for (int i = 1; i <= N; i++) {
            int gcd = calculateGCD(accLeft[i - 1], accRight[i + 1]);
            if (arr[i] % gcd != 0 && maxGCD < gcd) {
                maxGCD = gcd;
                maxK = arr[i];
            }
        }
        System.out.println(maxGCD > 0 ? maxGCD + " " + maxK : "-1");
    }
}
