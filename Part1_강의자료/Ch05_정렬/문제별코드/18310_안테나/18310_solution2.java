import java.util.Arrays;
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] xs = new int[N];
        for (int i = 0; i < N; i++)
            xs[i] = sc.nextInt();

        Arrays.sort(xs);

        System.out.println(xs[(N - 1) / 2]);
    }
}
