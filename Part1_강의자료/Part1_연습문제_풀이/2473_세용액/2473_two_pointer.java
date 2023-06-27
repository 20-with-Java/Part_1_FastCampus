import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int ans1 = arr[0];
        int ans2 = arr[1];
        int ans3 = arr[2];
        long ansAbs = Math.abs((long)arr[0] + arr[1] + arr[2]);
        for (int i = 0; i < N - 2; i++) {
            int leftIndex = i + 1;
            int rightIndex = N - 1;
            while (leftIndex < rightIndex) {
                long currentSum = (long)arr[i] + arr[leftIndex] + arr[rightIndex];
                long currentAbs = Math.abs(currentSum);
                if (ansAbs > currentAbs) {
                    ans1 = arr[i];
                    ans2 = arr[leftIndex];
                    ans3 = arr[rightIndex];
                    ansAbs = currentAbs;
                }
                if (currentSum <= 0) leftIndex++;
                else rightIndex--;
            }
        }

        System.out.println(ans1 + " " + ans2 + " " + ans3);
    }
}
