import java.util.Scanner;

class Main
{
    public static int generate(int seed) {
        int generatedNumber = seed;
        while (seed > 0) {
            generatedNumber += seed % 10;
            seed /= 10;
        }
        return generatedNumber;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int ans = 0;
        for (int i = 1; i <= N; i++)
            if (generate(i) == N) {
                ans = i;
                break;
            }

        System.out.println(ans);
    }
}
