import java.util.Arrays;
import java.util.Scanner;

class Main
{
    static class Score {
        int staff;
        double scr;
        public Score(char staff, double scr) {
            this.staff = staff;
            this.scr = scr;
        }
    }

    public static void sortScores(Score[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j].scr > arr[i].scr) {
                    Score cur = arr[i];
                    for (int k = i; k > j; k--)
                        arr[k] = arr[k - 1];
                    arr[j] = cur;
                    break;
                }
            }
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();
        char[] staff = new char[N];
        int[] vote = new int[N];
        for (int i = 0; i < N; i++) {
            staff[i] = sc.next().charAt(0);
            vote[i] = sc.nextInt();
        }

        double cut = X * 0.05;
        int cand = 0;
        for (int i = 0; i < N; i++)
            if (vote[i] >= cut) cand++;

        Score[] scores = new Score[cand * 14];
        int score_idx = 0;
        for (int i = 0; i < N; i++)
            if (vote[i] >= cut) {
                for (int j = 1; j <= 14; j++)
                    scores[score_idx++] = new Score(staff[i], (double) vote[i] / j);
            }

        sortScores(scores);
        int[] ans = new int[26];
        Arrays.fill(ans, -1);
        for (int i = 0; i < N; i++)
            if (vote[i] >= cut) ans[staff[i] - 'A'] = 0;
        for (int i = 0; i < 14; i++)
            ans[scores[scores.length - i - 1].staff - 'A']++;

        for (int i = 0; i < 26; i++)
            if (ans[i] >= 0)
                System.out.println((char)('A' + i) + " " + ans[i]);
    }
}
