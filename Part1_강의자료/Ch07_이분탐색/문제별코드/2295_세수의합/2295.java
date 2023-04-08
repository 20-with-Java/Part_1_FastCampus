import java.util.Arrays;
import java.util.Scanner;

class Main
{
    static boolean isExist(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < x) l = m + 1;
            else if (arr[m] > x) r = m - 1;
            else return true;
        }
        return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] sums = new int[N * (N + 1) / 2];
        int sumIndex = 0;
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                sums[sumIndex++] = arr[i] + arr[j];

        Arrays.sort(sums);

        int ans = -1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if (isExist(sums, target))
                    ans = Math.max(ans, arr[i]);
            }
        System.out.println(ans);
    }
}
