import java.util.Arrays;

class Main
{
    final static int MAX_NUMBER = 10000;

    public static int generate(int seed) {
        int generatedNumber = seed;
        while (seed > 0) {
            generatedNumber += seed % 10;
            seed /= 10;
        }
        return generatedNumber;
    }

    public static void main (String[] args) {
        boolean[] isSelfNumber = new boolean[MAX_NUMBER + 1];
        Arrays.fill(isSelfNumber, true);

        for (int i = 1; i <= MAX_NUMBER; i++) {
            int seed = i;
            while (true) {
                int generatedNumber = generate(seed);
                if (generatedNumber > MAX_NUMBER)
                    break;
                isSelfNumber[generatedNumber] = false;
                seed = generatedNumber;
            }
        }

        for (int i = 1; i <= MAX_NUMBER; i++)
            if (isSelfNumber[i])
                System.out.println(i);
    }
}
