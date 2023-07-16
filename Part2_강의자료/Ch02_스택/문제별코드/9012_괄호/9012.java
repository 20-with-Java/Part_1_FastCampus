import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            char[] input = sc.next().toCharArray();
            int openCount = 0;
            for (char ch : input) {
                if (ch == '(') openCount++;
                else if (ch == ')') {
                    openCount--;
                    if (openCount < 0) break;
                }
            }

            System.out.println(openCount == 0 ? "YES" : "NO");
        }
    }
}
