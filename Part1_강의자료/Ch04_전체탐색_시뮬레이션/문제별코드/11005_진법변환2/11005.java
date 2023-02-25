import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        String ans = "";
        while (N > 0) {
            int digit = N % B;
            if (digit < 10) ans += digit;
            else ans += (char)('A' + digit - 10);
            N /= B;
        }

        System.out.println(new StringBuilder(ans).reverse());
    }
}
