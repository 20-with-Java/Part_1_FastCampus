import java.util.Scanner;

class Main
{
    public static int[] getAlphabetCountArray(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'a']++;
        return count;
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] countA = getAlphabetCountArray(a);
        int[] countB = getAlphabetCountArray(b);

        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans += Math.abs(countA[i] - countB[i]);
        System.out.println(ans);
    }
}
