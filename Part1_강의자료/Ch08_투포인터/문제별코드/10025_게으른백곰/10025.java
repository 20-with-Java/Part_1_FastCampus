import java.util.Arrays;
import java.util.Scanner;

class Main
{
    static class Bucket {
        int g;
        int x;
        Bucket(int g, int x) {
            this.g = g;
            this.x = x;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        Bucket[] buckets = new Bucket[N];
        for (int i = 0; i < N; i++)
            buckets[i] = new Bucket(sc.nextInt(), sc.nextInt());

        Arrays.sort(buckets, (o1, o2) -> o1.x - o2.x);

        int nextIndex = 0;
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N && buckets[nextIndex].x - buckets[i].x <= 2 * K) {
                currentSum += buckets[nextIndex++].g;
            }
            maxSum = Math.max(maxSum, currentSum);
            currentSum -= buckets[i].g;
        }
        System.out.println(maxSum);
    }
}
