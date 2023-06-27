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

        String[] unseen = new String[M];
        for (int i = 0; i < M; i++)
            unseen[i] = sc.next();

        Arrays.sort(unhear);
        Arrays.sort(unseen);

        int pairIndex = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            while (pairIndex < M && unseen[pairIndex].compareTo(unhear[i]) < 0)
                pairIndex++;
            if (pairIndex < M && unseen[pairIndex].equals(unhear[i]))
                ans.add(unhear[i]);
        }

        System.out.println(ans.size());
        for (String name : ans)
            System.out.println(name);
    }
}
