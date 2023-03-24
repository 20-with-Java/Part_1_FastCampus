import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] xs = new int[N];
        Set<Integer> setX = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            xs[i] = Integer.parseInt(inputs[i]);
            setX.add(xs[i]);
        }

        Map<Integer, Integer> sortedIndex = new HashMap<>();
        int idx = 0;
        for (int x : setX)
            sortedIndex.put(x, idx++);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++)
            bw.write(sortedIndex.get(xs[i]) + " ");
        bw.flush();
    }
}
