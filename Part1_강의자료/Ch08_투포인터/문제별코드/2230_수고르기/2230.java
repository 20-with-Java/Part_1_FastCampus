import java.util.Arrays;
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

        Arrays.sort(arr);
        
        int ansDiff = arr[N - 1] - arr[0];
        int rightIndex = 0;
        for (int leftIndex = 0; leftIndex < N; leftIndex++) {
            while (arr[rightIndex] - arr[leftIndex] < M && rightIndex < N - 1)
                rightIndex++;
            int diff = arr[rightIndex] - arr[leftIndex];
            if (diff >= M) ansDiff = Math.min(ansDiff, diff);
        }
        System.out.println(ansDiff);
    }
}
