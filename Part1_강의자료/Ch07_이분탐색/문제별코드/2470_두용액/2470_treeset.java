import java.util.Scanner;
import java.util.TreeSet;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int ansAbs = 2000000001;
        int ans1 = 0;
        int ans2 = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            Integer[] pairValues = {set.floor(-x), set.ceiling(-x)};
            for (Integer pairValue : pairValues) {
                if (pairValue == null) continue;
                int sumAbs = Math.abs(x + pairValue);
                if (ansAbs > sumAbs) {
                    ansAbs = sumAbs;
                    ans1 = x;
                    ans2 = pairValue;
                }
            }
            set.add(x);
        }
        System.out.println(Math.min(ans1, ans2) + " " + Math.max(ans1, ans2));
    }
}
