import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] expression = sc.next().toCharArray();
        int[] value = new int[N];
        for (int i = 0; i < N; i++)
            value[i] = sc.nextInt();

        double[] calc = new double[expression.length];
        int calcIndex = -1;
        for (char ch : expression) {
            if ('A' <= ch && ch <= 'Z') {
                calc[++calcIndex] = value[ch - 'A'];
            }
            else {
                double result = calc[calcIndex - 1];
                if (ch == '+') result += calc[calcIndex];
                else if (ch == '-') result -= calc[calcIndex];
                else if (ch == '*') result *= calc[calcIndex];
                else if (ch == '/') result /= calc[calcIndex];
                calc[--calcIndex] = result;
            }
        }
        System.out.printf("%.2f\n", calc[0]);
    }
}
