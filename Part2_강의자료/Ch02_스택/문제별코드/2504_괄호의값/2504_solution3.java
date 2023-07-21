import java.util.*;

class Main
{
    static int delimiterToValue(char delimiter) {
        if (delimiter == '(' || delimiter == ')') return 2;
        else if (delimiter == '[' || delimiter == ']') return 3;
        return -1;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();

        int[] stack = new int[input.length];
        int topIndex = -1;
        int currentMultiple = 1;
        int ans = 0;
        for (int i = 0; i < input.length; i++) {
            int delimiterValue = delimiterToValue(input[i]);
            if (input[i] == '(' || input[i] == '[') {
                stack[++topIndex] = delimiterValue;
                currentMultiple *= delimiterValue;
            }
            else {
                if (topIndex < 0 || stack[topIndex--] != delimiterValue) {
                    ans = 0;
                    break;
                }
                if (input[i - 1] == '(' || input[i - 1] == '[')
                    ans += currentMultiple;
                currentMultiple /= delimiterValue;
            }
        }
        System.out.println(topIndex < 0 ? ans : 0);
    }
}
