import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            char[] input = sc.next().toCharArray();
            Deque<Character> st = new ArrayDeque<>();
            boolean isValid = true;
            for (char ch : input) {
                if (ch == '(') {
                    st.offerLast('(');
                }
                else if (ch == ')') {
                    if (st.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    st.pollLast();
                }
            }

            if (!st.isEmpty()) isValid = false;
            System.out.println(isValid ? "YES" : "NO");
        }
    }
}
