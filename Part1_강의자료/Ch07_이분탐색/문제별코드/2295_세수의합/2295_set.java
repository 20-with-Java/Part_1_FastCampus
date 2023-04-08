import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                sums.add(arr[i] + arr[j]);

        int ans = -1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if (sums.contains(target))
                    ans = Math.max(ans, arr[i]);
            }
        System.out.println(ans);
    }
}
