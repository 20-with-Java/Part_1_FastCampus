import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();
        char[] color = sc.next().toCharArray();

        int currentWhiteCount = 0;
        int currentBlackCount = 0;
        int ansLength = 0;
        int nextIndex = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N) {
                if (currentBlackCount == B && color[nextIndex] == 'B') break;
                if (color[nextIndex++] == 'W') currentWhiteCount++;
                else currentBlackCount++;
            }
            if (currentWhiteCount >= W)
                ansLength = Math.max(ansLength, nextIndex - i);

            if (color[i] == 'W') currentWhiteCount--;
            else currentBlackCount--;
        }

        System.out.println(ansLength);
    }
}
