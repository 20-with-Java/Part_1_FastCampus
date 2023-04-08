import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            set.add(sc.nextInt());
        int M = sc.nextInt();
        while (M-- > 0) {
            int x = sc.nextInt();
            System.out.println(set.contains(x) ? 1 : 0);
        }
    }
}
