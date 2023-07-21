import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int N = input.length();
        char[] arr = new char[N + 1];
        System.arraycopy(input.toCharArray(), 0, arr, 1, N);

        int[] accLaser = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            accLaser[i] = accLaser[i - 1];
            if (arr[i] == '(' && arr[i + 1] == ')')
                accLaser[i]++;
        }

        int ans = 0;
        int[] opened = new int[N + 1];
        int topIndex = -1;
        for (int i = 1; i <= N; i++) {
            if (arr[i] == '(' && arr[i + 1] != ')') {
                opened[++topIndex] = i;
            }
            else if (arr[i] == ')' && arr[i - 1] != '(') {
                int openIndex = opened[topIndex--];
                ans += accLaser[i] - accLaser[openIndex - 1] + 1;
            }
        }
        System.out.println(ans);
    }
}
