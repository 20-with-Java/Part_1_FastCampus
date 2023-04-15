import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] distance = new int[N];
        int distanceSum = 0;
        for (int i = 0; i < N; i++) {
            distance[i] = sc.nextInt();
            distanceSum += distance[i];
        }

        int pairIndex = 1;
        int leftDistance = distance[0];
        int rightDistance = distanceSum - distance[0];
        int maxDistance = Math.min(leftDistance, rightDistance);
        for (int i = 0; i < N; i++) {
            while (leftDistance < rightDistance) {
                leftDistance += distance[pairIndex];
                rightDistance -= distance[pairIndex];
                pairIndex = (pairIndex + 1) % N;
            }
            maxDistance = Math.max(maxDistance, Math.min(leftDistance, rightDistance));

            leftDistance -= distance[i];
            rightDistance += distance[i];
        }
        System.out.println(maxDistance);
    }
}
