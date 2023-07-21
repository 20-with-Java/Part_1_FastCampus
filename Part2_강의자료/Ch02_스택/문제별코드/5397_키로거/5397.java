import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            char[] input = sc.next().toCharArray();
            Deque<Character> beforCursor = new ArrayDeque<>();
            Deque<Character> afterCursor = new ArrayDeque<>();
            for (char cmd : input) {
                if (cmd == '-') {
                    beforCursor.pollLast();
                }
                else if (cmd == '<') {
                    if (!beforCursor.isEmpty())
                        afterCursor.offerLast(beforCursor.pollLast());
                }
                else if (cmd == '>') {
                    if (!afterCursor.isEmpty())
                        beforCursor.offerLast(afterCursor.pollLast());
                }
                else {
                    beforCursor.offerLast(cmd);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!beforCursor.isEmpty()) sb.append(beforCursor.pollFirst());
            while (!afterCursor.isEmpty()) sb.append(afterCursor.pollLast());
            System.out.println(sb);
        }
    }
}
