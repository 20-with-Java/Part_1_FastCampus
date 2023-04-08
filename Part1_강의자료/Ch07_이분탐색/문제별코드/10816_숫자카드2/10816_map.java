import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main
{
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = sc.nextInt();
        while (M-- > 0) {
            int x = sc.nextInt();
            bw.write(map.getOrDefault(x, 0) + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
