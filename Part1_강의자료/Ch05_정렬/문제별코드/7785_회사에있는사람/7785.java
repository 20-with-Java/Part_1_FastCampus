import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[][] records = new String[N][2];
        for (int i = 0; i < N; i++) {
            records[i][0] = sc.next();
            records[i][1] = sc.next();
        }

        Arrays.sort(records, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o2[0].compareTo(o1[0]);
            }
        });

        for (int i = 0; i < N - 1; i++) {
            if (records[i][1].equals("enter") && !records[i][0].equals(records[i + 1][0]))
                System.out.println(records[i][0]);
        }
        if (records[N - 1][1].equals("enter"))
            System.out.println(records[N - 1][0]);
    }
}
