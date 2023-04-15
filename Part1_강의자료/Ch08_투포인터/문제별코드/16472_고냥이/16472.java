import java.util.Scanner;

class Main
{
    static int[] currentAlphabetFrequency = new int[26];
    static int currentUniqueAlphabetCount = 0;

    static void increaseFrequency(char alphabet) {
        if (currentAlphabetFrequency[alphabet - 'a']++ == 0)
            currentUniqueAlphabetCount++;
    }

    static void decreaseFrequency(char alphabet) {
        if (--currentAlphabetFrequency[alphabet - 'a'] == 0)
            currentUniqueAlphabetCount--;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] nyang = sc.next().toCharArray();
        int nextIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < nyang.length; i++) {
            while (nextIndex < nyang.length) {
                increaseFrequency(nyang[nextIndex++]);
                if (currentUniqueAlphabetCount > N) {
                    decreaseFrequency(nyang[--nextIndex]);
                    break;
                }
            }
            maxLength = Math.max(maxLength, nextIndex - i);
            decreaseFrequency(nyang[i]);
        }
        System.out.println(maxLength);
    }
}
