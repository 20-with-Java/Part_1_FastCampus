import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();

        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'A']++;

        int maxCount = 0;
        char maxAlphabet = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxAlphabet = (char)('A' + i);
            } else if (count[i] == maxCount) {
                maxAlphabet = '?';
            }
        }
        System.out.println(maxAlphabet);
    }
}
