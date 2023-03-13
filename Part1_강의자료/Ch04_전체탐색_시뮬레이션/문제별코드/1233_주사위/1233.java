import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int S1 = sc.nextInt();
        int S2 = sc.nextInt();
        int S3 = sc.nextInt();

        int maxNumber = S1 + S2 + S3;
        int[] count = new int[maxNumber + 1];
        for (int i = 1; i <= S1; i++)
            for (int j = 1; j <= S2; j++)
                for (int k = 1; k <= S3; k++)
                    count[i + j + k]++;

        int ans = 1;
        int ansCount = count[1];
        for (int i = 2; i <= maxNumber; i++)
            if (count[i] > ansCount) {
                ans = i;
                ansCount = count[i];
            }

        System.out.println(ans);
    }
}
