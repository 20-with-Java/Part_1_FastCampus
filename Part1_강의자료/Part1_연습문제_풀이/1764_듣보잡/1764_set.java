import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> unhear = new HashSet<>();
        for (int i = 0; i < N; i++)
            unhear.add(sc.next());

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = sc.next();
            if (unhear.contains(name))
                ans.add(name);
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (String name : ans)
            System.out.println(name);
    }
}
