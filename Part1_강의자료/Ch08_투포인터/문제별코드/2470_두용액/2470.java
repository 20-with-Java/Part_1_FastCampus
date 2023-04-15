import java.util.Arrays;
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int leftIndex = 0;
        int rightIndex = N - 1;
        int ansLeftIndex = leftIndex;
        int ansRightIndex = rightIndex;
        int ansAbs = Math.abs(arr[ansLeftIndex] + arr[ansRightIndex]);
        while (leftIndex < rightIndex) {
            int currentSum = arr[leftIndex] + arr[rightIndex];
            int currentAbs = Math.abs(currentSum);
            if (ansAbs > currentAbs) {
                ansAbs = currentAbs;
                ansLeftIndex = leftIndex;
                ansRightIndex = rightIndex;
            }
            if (currentSum > 0) rightIndex--;
            else leftIndex++;
        }
        System.out.println(arr[ansLeftIndex] + " " + arr[ansRightIndex]);
    }
}
