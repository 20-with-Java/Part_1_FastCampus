import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] stack = new int[N];
        int topIndex = -1;
        int nextNumber = 1;
        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            while (nextNumber <= x) {
                sb.append("+\n");
                stack[++topIndex] = nextNumber++;
            }
            if (topIndex < 0 || stack[topIndex] != x) {
                sb.setLength(0);
                sb.append("NO\n");
                break;
            }
            sb.append("-\n");
            topIndex--;
        }
        System.out.println(sb);
    }
}
