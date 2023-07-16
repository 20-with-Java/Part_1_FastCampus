import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        char[] digits = sc.next().toCharArray();

        int ansLength = N - K;
        char[] maxDigits = new char[N];
        int topIndex = -1;
        for (char d : digits) {
            while (K > 0 && topIndex >= 0 && maxDigits[topIndex] < d) {
                topIndex--;
                K--;
            }
            maxDigits[++topIndex] = d;
        }
        System.out.println(new String(maxDigits, 0, ansLength));
    }
}
