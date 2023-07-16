import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        char[] rewind = new char[input.length];
        int len = 0;
        for (char ch : input) {
            rewind[len++] = ch;
            if (len >= 4 && rewind[len - 1] == 'P' && rewind[len - 2] == 'A'
                    && rewind[len - 3] == 'P' && rewind[len - 4] == 'P')
                len -= 3;
        }
        System.out.println(len == 1 && rewind[0] == 'P' ? "PPAP" : "NP");
    }
}
