import java.util.Scanner;

class Main
{
    static int getUniqueAlphabetCount(int[] alphabetCount) {
        int uniqueAlphabetCount = 0;
        for (int i = 0; i < alphabetCount.length; i++)
            if (alphabetCount[i] > 0)
                uniqueAlphabetCount++;
        return uniqueAlphabetCount;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] nyang = sc.next().toCharArray();

        int[] currentAlphabetFrequency = new int[26];
        int nextIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < nyang.length; i++) {
            while (nextIndex < nyang.length) {
                currentAlphabetFrequency[nyang[nextIndex++] - 'a']++;
                if (getUniqueAlphabetCount(currentAlphabetFrequency) > N) {
                    currentAlphabetFrequency[nyang[--nextIndex] - 'a']--;
                    break;
                }
            }
            maxLength = Math.max(maxLength, nextIndex - i);
            currentAlphabetFrequency[nyang[i] - 'a']--;
        }
        System.out.println(maxLength);
    }
}
