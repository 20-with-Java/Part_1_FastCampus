import java.util.Arrays;
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] xs = new int[N];
        for (int i = 0; i < N; i++)
            xs[i] = sc.nextInt();

        Arrays.sort(xs);
        
        // 가장 왼쪽 집에 안테나를 설치했을 때 거리 합을 구한다.
        int optimalAntenaX = xs[0];
        long optimalDistanceSum = 0;
        for (int i = 0; i < N; i++)
            optimalDistanceSum += xs[i] - xs[0];
        
        long pastDistanceSum = 0;
        for (int i = 1; i < N; i++) {
            // 오른쪽집으로 안테나 설치 위치를 옮겼을 때 거리 합을 계산해본다.
            int movedDistance = xs[i] - xs[i - 1];
            long currentDistanceSum = pastDistanceSum;
            currentDistanceSum += (long)i * movedDistance;          // i - 1에 설치했을때보다 멀어지는 집들의 거리
            currentDistanceSum -= (long)(N - i) * movedDistance;    // i - 1에 설치했을때보다 가까워지는 집들의 거리
            if (currentDistanceSum < optimalDistanceSum) {
                optimalAntenaX = xs[i];
                optimalDistanceSum = currentDistanceSum;
            }
            pastDistanceSum = currentDistanceSum;
        }

        System.out.println(optimalAntenaX);
    }
}
