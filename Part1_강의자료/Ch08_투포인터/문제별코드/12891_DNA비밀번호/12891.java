import java.util.Scanner;

class Main
{
    static int baseToIndex(char alp) {
        if (alp == 'A') return 0;
        else if (alp == 'C') return 1;
        else if (alp == 'G') return 2;
        else if (alp == 'T') return 3;
        return -1;
    }

    static boolean isValidSequence(int[] baseCount, int[] minimumBaseCount) {
        for (int i = 0; i < baseCount.length; i++)
            if (baseCount[i] < minimumBaseCount[i])
                return false;
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int P = sc.nextInt();
        char[] sequence = sc.next().toCharArray();
        int[] minimumBaseCount = new int[4];
        for (int i = 0; i < 4; i++)
            minimumBaseCount[i] = sc.nextInt();

        int[] currentBaseCount = new int[4];
        for (int i = 0; i < P; i++)
            currentBaseCount[baseToIndex(sequence[i])]++;
        int ans = isValidSequence(currentBaseCount, minimumBaseCount) ? 1 : 0;

        for (int i = 1; i <= S - P; i++) {
            currentBaseCount[baseToIndex(sequence[i - 1])]--;
            currentBaseCount[baseToIndex(sequence[i + P - 1])]++;
            if (isValidSequence(currentBaseCount, minimumBaseCount))
                ans++;
        }
        System.out.println(ans);
    }
}
