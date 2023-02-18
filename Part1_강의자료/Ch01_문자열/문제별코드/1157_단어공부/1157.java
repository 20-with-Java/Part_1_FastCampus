import java.util.Scanner;

class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();

        int[] count = new int['Z' + 1];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        int max_count = 0;
        char max_alp = '?';
        for (char alp = 'A'; alp <= 'Z'; alp++) {
            if (count[alp] > max_count) {
                max_count = count[alp];
                max_alp = alp;
            }
            else if (count[alp] == max_count) {
                max_alp = '?';
            }
        }
        System.out.println(max_alp);
    }
}
