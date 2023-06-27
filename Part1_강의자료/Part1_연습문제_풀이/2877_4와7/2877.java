import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        String ans = Integer.toBinaryString(K + 1)
                .replace('0', '4')
                .replace('1', '7');
        System.out.println(ans.substring(1));
    }
}
