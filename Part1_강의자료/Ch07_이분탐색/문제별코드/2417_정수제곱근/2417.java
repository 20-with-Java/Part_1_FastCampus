import java.util.Scanner;

class Main
{
    static long calcSqrtInteger(long x) {
        if (x == 0) return 0;

        long l = 1, r = 1L << 32, sqrt = -1;
        while(l <= r) {
            long m = (r + l) / 2;
            if (m >= (x - 1) / m + 1) {
                r = m - 1;
                sqrt = m;
            }
            else l = m + 1;
        }
        return sqrt;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        System.out.println(calcSqrtInteger(N));
    }
}
