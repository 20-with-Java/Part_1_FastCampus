import java.util.Scanner;

class Main
{
    public static int findNewGloryIdx(int[][] glory) {
        for (int i = 0; i < glory.length; i++)
            if (glory[i][0] == 0)
                return i;

        int targetGloryIdx = 0;
        for (int i = 1; i < glory.length; i++) {
            if (glory[i][1] < glory[targetGloryIdx][1])
                targetGloryIdx = i;
            else if (glory[i][1] == glory[targetGloryIdx][1]) {
                if (glory[i][2] < glory[targetGloryIdx][2])
                    targetGloryIdx = i;
            }
        }
        return targetGloryIdx;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int R = sc.nextInt();
        int[] recommend = new int[R];
        for (int i = 0; i < R; i++)
            recommend[i] = sc.nextInt();

        // [i]: i번째 학생의 [0]: 번호, [1]: 현재 투표수, [2]: 전시된 시점
        int[][] glory = new int[N][3];
        for (int i = 0; i < R; i++) {
            int idx = recommend[i];
            boolean already = false;
            for (int j = 0; j < N; j++)
                if (glory[j][0] == idx) {
                    glory[j][1]++;
                    already = true;
                    break;
                }

            if (!already) {
                int gloryIdx = findNewGloryIdx(glory);
                glory[gloryIdx][0] = idx;
                glory[gloryIdx][1] = 1;
                glory[gloryIdx][2] = i;
            }
        }

        boolean[] ans = new boolean[101];
        for (int i = 0; i < N; i++)
            ans[glory[i][0]] = true;
        for (int i = 1; i <= 100; i++)
            if (ans[i]) System.out.print(i + " ");
        System.out.println();
    }
}
