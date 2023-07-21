import java.util.*;

class Element {
    enum Type { DELIMITER, SCORE }
    Type type;
    int value;
    Element (Type type, int value) {
        this.type = type;
        this.value = value;
    }
}

class Main
{
    static int delimiterToValue(char delimiter) {
        if (delimiter == '(' || delimiter == ')') return 2;
        else if (delimiter == '[' || delimiter == ']') return 3;
        return -1;
    }

    static boolean isValidInput(char[] input) {
        char[] stack = new char[input.length];
        int topIndex = -1;
        for (char ch : input) {
            if (ch == '(' || ch == '[')
                stack[++topIndex] = ch;
            else {
                if (topIndex < 0) return false;
                if (delimiterToValue(stack[topIndex]) != delimiterToValue(ch))
                    return false;
                topIndex--;
            }
        }
        return topIndex < 0;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        if (!isValidInput(input)) {
            System.out.println(0);
            return ;
        }

        Element[] stack = new Element[31];
        int topIndex = -1;
        for (char ch : input) {
            if (ch == '(' || ch == '[')
                stack[++topIndex] = new Element(Element.Type.DELIMITER, delimiterToValue(ch));
            else {
                int innerScore = 0;
                while (stack[topIndex].type == Element.Type.SCORE)
                    innerScore += stack[topIndex--].value;
                int score = innerScore * delimiterToValue(ch);
                if (score == 0) score = delimiterToValue(ch);
                stack[topIndex] = new Element(Element.Type.SCORE, score);
            }
        }

        int ans = 0;
        while (topIndex >= 0)
            ans += stack[topIndex--].value;
        System.out.println(ans);
    }
}
