import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int currentRemain = 0;
        Map<Integer, Integer> remainCount = new HashMap<>();
        remainCount.put(currentRemain, 1);
        long ans = 0;
        for (int i = 0; i < N; i++) {
            currentRemain = (currentRemain + sc.nextInt()) % M;
            ans += remainCount.getOrDefault(currentRemain, 0);
            remainCount.put(currentRemain, remainCount.getOrDefault(currentRemain, 0) + 1);
        }
        System.out.println(ans);
    }
}
