
import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] unhear = new String[N];
        for (int i = 0; i < N; i++)
            unhear[i] = sc.next();
        Arrays.sort(unhear);

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = sc.next();
            if (Arrays.binarySearch(unhear, name) >= 0)
                ans.add(name);
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (String name : ans)
            System.out.println(name);
    }
}
