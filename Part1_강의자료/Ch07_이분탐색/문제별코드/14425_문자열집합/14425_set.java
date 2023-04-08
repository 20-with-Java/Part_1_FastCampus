import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            set.add(sc.next());

        int count = 0;
        while (M-- > 0) {
            String x = sc.next();
            if (set.contains(x))
                count++;
        }
        System.out.println(count);
    }
}
