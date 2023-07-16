import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++)
            heights[i] = sc.nextInt();

        long ans = 0;
        int[] descHeight = new int[N];
        int topIndex = -1;
        for (int h : heights) {
            while (topIndex >= 0 && descHeight[topIndex] <= h)
                topIndex--;

            descHeight[++topIndex] = h;
            ans += topIndex;
        }
        System.out.println(ans);
    }
}
