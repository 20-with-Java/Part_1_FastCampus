import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] names = new String[N + M];
        for (int i = 0; i < N; i++)
            names[i] = sc.next();
        for (int i = 0; i < M; i++)
            names[N + i] = sc.next();

        Arrays.sort(names);
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < N + M; i++)
            if (names[i].equals(names[i - 1])) {
                ans.add(names[i]);
                i++;
            }

        System.out.println(ans.size());
        for (String name : ans)
            System.out.println(name);
    }
}
