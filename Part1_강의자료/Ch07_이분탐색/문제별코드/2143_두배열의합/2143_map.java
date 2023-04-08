import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main
{
    static Map<Integer, Integer> getAllPartSumCount(int[] arr) {
        int N = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
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

        Map<Integer, Integer> partSum1 = getAllPartSumCount(arr1);
        Map<Integer, Integer> partSum2 = getAllPartSumCount(arr2);

        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : partSum1.entrySet()) {
            int sum = entry.getKey();
            int count = entry.getValue();
            ans += (long)count * partSum2.getOrDefault(T - sum, 0);
        }
        System.out.println(ans);
    }
}
