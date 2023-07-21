import java.util.*;

class Status {
    char openDelimiter;
    int innerSum;
    Status (char openDelimiter) {
        this.openDelimiter = openDelimiter;
        this.innerSum = 0;
    }
}

class Main
{
    static int delimiterToValue(char delimiter) {
        if (delimiter == '(' || delimiter == ')') return 2;
        else if (delimiter == '[' || delimiter == ']') return 3;
        return -1;
    }

    static boolean isMatchedDelimiter(char openDelimiter, char closeDelimiter) {
        if (openDelimiter == '(' && closeDelimiter == ')')
            return true;
        else if (openDelimiter == '[' && closeDelimiter == ']')
            return true;
        return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        Status[] stack = new Status[31];
        int topIndex = -1;
        stack[++topIndex] = new Status(' ');
        for (char ch : input) {
            if (ch == '(' || ch == '[')
                stack[++topIndex] = new Status(ch);
            else {
                if (topIndex < 0 || !isMatchedDelimiter(stack[topIndex].openDelimiter, ch)) {
                    stack[0].innerSum = 0;
                    break;
                }
                int score = stack[topIndex].innerSum * delimiterToValue(ch);
                if (score == 0) score = delimiterToValue(ch);
                stack[--topIndex].innerSum += score;
            }
        }
        System.out.println(topIndex == 0 ? stack[topIndex].innerSum : 0);
    }
}
