import java.util.Arrays;
import java.util.Scanner;

class Main
{
    static int findNearestValue(int[] arr, int leftIndex, int rightIndex, int findValue) {
        int nearestValue = arr[leftIndex];
        int nearestDiff = Math.abs(findValue - nearestValue);
        int l = leftIndex + 1, r = rightIndex;
        while (l <= r) {
            int m = (l + r) / 2;
            int diff = Math.abs(findValue - arr[m]);
            if (diff < nearestDiff) {
                nearestValue = arr[m];
                nearestDiff = diff;
            }
            if (arr[m] < findValue) l = m + 1;
            else if (arr[m] > findValue) r = m - 1;
            else return findValue;
        }
        return nearestValue;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int ansAbs = Math.abs(arr[0] + arr[1]);
        int ans1 = arr[0];
        int ans2 = arr[1];
        for (int i = 0; i < N - 1; i++) {
            int pairValue = findNearestValue(arr, i + 1, N - 1, -arr[i]);
            int sumAbs = Math.abs(arr[i] + pairValue);
            if (ansAbs > sumAbs) {
                ansAbs = sumAbs;
                ans1 = arr[i];
                ans2 = pairValue;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
