import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int ansLength = N + 1;
        int nextIndex = 0;
        int currentSum = 0;
        for (int i = 0; i < N; i++) {
            while (currentSum < M && nextIndex < N)
                currentSum += arr[nextIndex++];
            if (currentSum >= M) ansLength = Math.min(ansLength, nextIndex - i);
            currentSum -= arr[i];
        }

        if (ansLength > N) ansLength = 0;
        System.out.println(ansLength);
    }
}
