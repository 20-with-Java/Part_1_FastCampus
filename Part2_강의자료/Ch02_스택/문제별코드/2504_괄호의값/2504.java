import java.util.*;

class Status {
    char matchClose;
    int multipleValue;
    int innerScore;
    Status (char matchClose, int multipleValue, int innerScore) {
        this.matchClose = matchClose;
        this.multipleValue = multipleValue;
        this.innerScore = innerScore;
    }
}

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        Status[] st = new Status[31];
        int topIndex = -1;
        st[++topIndex] = new Status(' ', 1, 0);
        for (char ch : input) {
            if (ch == '(') {
                st[++topIndex] = new Status(')', 2, 0);
            }
            else if (ch == '[') {
                st[++topIndex] = new Status(']', 3, 0);
            }
            else {
                if (st[topIndex].matchClose != ch) {
                    st[0].innerScore = 0;
                    break;
                }
                int score = st[topIndex].innerScore * st[topIndex].multipleValue;
                if (score == 0) score = st[topIndex].multipleValue;
                st[topIndex - 1].innerScore += score;
                topIndex--;
            }
        }
        System.out.println(topIndex == 0 ? st[0].innerScore : 0);
    }
}
