import java.util.*;

class Main
{
    static int findOptimalPairValue(int[] arr, int fromIndex, int toIndex, int value) {
        long optimalPairAbs = 3000000000L;
        int optimalPairValue = 0;
        int l = fromIndex, r = toIndex;
        while (l <= r) {
            int m = (l + r) / 2;
            long sum = value + arr[m];
            long sumAbs = Math.abs(sum);
            if (sumAbs < optimalPairAbs) {
                optimalPairValue = arr[m];
                optimalPairAbs = sumAbs;
            }
            if (sum < 0) l = m + 1;
            else if (sum > 0) r = m - 1;
            else return arr[m];
        }
        return optimalPairValue;
    }

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
        for (int i = 0; i < N - 2; i++)
            for (int j = i + 1; j < N - 1; j++) {
                int pairValue = findOptimalPairValue(arr, j + 1, N - 1, arr[i] + arr[j]);
                long abs = Math.abs((long)arr[i] + arr[j] + pairValue);
                if (abs < ansAbs) {
                    ans1 = arr[i];
                    ans2 = arr[j];
                    ans3 = pairValue;
                    ansAbs = abs;
                }
            }

        System.out.println(ans1 + " " + ans2 + " " + ans3);
    }
}
