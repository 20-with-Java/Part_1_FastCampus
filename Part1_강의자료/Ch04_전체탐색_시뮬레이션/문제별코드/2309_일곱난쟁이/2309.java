import java.util.Arrays;
import java.util.Scanner;

class Main
{
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int cur = arr[i];
                    for (int k = i; k > j; k--)
                        arr[k] = arr[k - 1];
                    arr[j] = cur;
                    break;
                }
            }
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] h = new int[9];
        for (int i = 0; i < 9; i++)
            h[i] = sc.nextInt();

        // Arrays.sort(h);
        sort(h);

        int sum = Arrays.stream(h).sum();
        boolean find = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++)
                if (sum - h[i] - h[j] == 100) {
                    h[i] = h[j] = -1;
                    find = true;
                    break;
                }
            if (find) break;
        }

        for (int i = 0; i < 9; i++)
            if (h[i] > 0)
                System.out.println(h[i]);
    }
}
