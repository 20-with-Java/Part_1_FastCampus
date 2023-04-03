import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] origin = new int[N + 1];
        for (int i = 1; i <= N; i++)
            origin[i] = sc.nextInt();

        int[] delta = new int[N + 2];
        while (M-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            delta[a] += k;
            delta[b + 1] -= k;
        }

        int[] accDelta = new int[N + 1];
        for (int i = 1; i <= N; i++)
            accDelta[i] = accDelta[i - 1] + delta[i];

        for (int i = 1; i <= N; i++)
            System.out.print(origin[i] + accDelta[i] + " ");
        System.out.println();
    }
}
