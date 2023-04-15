import java.util.Arrays;
import java.util.Scanner;

class Main
{
    static boolean isPalindrome(char[] str, int l, int r) {
        while (l <= r) {
            if (str[l] != str[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            char[] str = sc.next().toCharArray();
            int ans = 0;
            int l = 0, r = str.length - 1;
            while (l <= r) {
                if (str[l] != str[r]) {
                    if (isPalindrome(str, l + 1, r) || isPalindrome(str, l, r - 1)) ans = 1;
                    else ans = 2;
                    break;
                }
                l++;
                r--;
            }
            System.out.println(ans);
        }
    }
}
