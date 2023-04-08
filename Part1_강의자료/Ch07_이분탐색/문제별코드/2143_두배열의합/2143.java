import java.util.Arrays;
import java.util.Scanner;

class Main
{
    static int findLowerBoundIndex(int[] arr, int x) {
        // x 이상의 값이 처음으로 나타나는 위치
        int lowerBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < x) l = m + 1;
            else {
                r = m - 1;
                lowerBoundIndex = m;
            }
        }
        return lowerBoundIndex;
    }

    static int findUpperBoundIndex(int[] arr, int x) {
        // x 초과의 값이 처음으로 나타나는 위치
        int upperBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= x) l = m + 1;
            else {
                r = m - 1;
                upperBoundIndex = m;
            }
        }
        return upperBoundIndex;
    }

    static int[] getAllPartSum(int[] arr) {
        int N = arr.length;
        int[] partSum = new int[N * (N + 1) / 2];
        int partSumIndex = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                partSum[partSumIndex++] = sum;
            }
        }
        return partSum;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++)
            arr1[i] = sc.nextInt();

        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++)
            arr2[i] = sc.nextInt();

        int[] partSum1 = getAllPartSum(arr1);
        int[] partSum2 = getAllPartSum(arr2);

        Arrays.sort(partSum2);

        long ans = 0;
        for (int sum1 : partSum1) {
            int pairSum = T - sum1;
            int lowerBoundIndex = findLowerBoundIndex(partSum2, pairSum);
            int upperBoundIndex = findUpperBoundIndex(partSum2, pairSum);
            ans += upperBoundIndex - lowerBoundIndex;
        }
        System.out.println(ans);
    }
}
