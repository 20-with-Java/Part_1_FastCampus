import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

class Main
{
    static int findLowerBoundIndex(int[] arr, int x) {
        // x 이상의 값이 처음으로 나타나는 위치
        int lowerBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < x) l = m + 1;
            else {
                r = m - 1;
                lowerBoundIndex = m;
            }
        }
        return lowerBoundIndex;
    }

    static int findUpperBoundIndex(int[] arr, int x) {
        // x 초과의 값이 처음으로 나타나는 위치
        int upperBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= x) l = m + 1;
            else {
                r = m - 1;
                upperBoundIndex = m;
            }
        }
        return upperBoundIndex;
    }

    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] cards = new int[N];
        for (int i = 0; i < N; i++)
            cards[i] = sc.nextInt();

        Arrays.sort(cards);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = sc.nextInt();
        while (M-- > 0) {
            int x = sc.nextInt();
            int lowerBoundIndex = findLowerBoundIndex(cards, x);
            int upperBoundIndex = findUpperBoundIndex(cards, x);
            bw.write(upperBoundIndex - lowerBoundIndex + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
