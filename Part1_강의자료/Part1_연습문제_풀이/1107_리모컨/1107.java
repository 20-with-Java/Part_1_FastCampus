import java.util.*;

class Main
{
    static boolean canMakeNumber(int x, boolean[] isBroken) {
        if (x == 0) return !isBroken[0];
        while (x > 0) {
            if (isBroken[x % 10])
                return false;
            x /= 10;
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] isBroken = new boolean[10];
        for (int i = 0; i < M; i++)
            isBroken[sc.nextInt()] = true;

        int ans = (N > 100 ? N - 100 : 100 - N);
        for (int delta = 0; delta < ans; delta++) {
            int[] numberToMake = {N + delta, N - delta};
            for (int number : numberToMake)
                if (number >= 0 && canMakeNumber(number, isBroken))
                    ans = Math.min(ans, Integer.toString(number).length() + delta);
        }
        System.out.println(ans);
    }
}
