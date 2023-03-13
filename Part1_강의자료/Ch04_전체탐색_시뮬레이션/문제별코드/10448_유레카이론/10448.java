import java.util.Scanner;

class Main
{
    static boolean[] isEurekaNumber = new boolean[1001];

    public static void preprocess() {
        int[] triangleNumbers = new int[50];
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i + 1) / 2;
            if (triangleNumber > 1000) break;
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }

        for (int i = 0; i < triangleNumberCount; i++)
            for (int j = i; j < triangleNumberCount; j++)
                for (int k = j; k < triangleNumberCount; k++) {
                    int eurekaNumber = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];
                    if (eurekaNumber > 1000) break;
                    isEurekaNumber[eurekaNumber] = true;
                }
    }

    public static void main (String[] args) {
        preprocess();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            System.out.println(isEurekaNumber[K] ? "1" : "0");
        }
    }
}
