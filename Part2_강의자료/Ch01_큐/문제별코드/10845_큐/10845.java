import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int lastValue = -1;
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push")) {
                lastValue = Integer.parseInt(cmd[1]);
                q.offer(lastValue);
            }
            else if (cmd[0].equals("pop")) {
                bw.write(q.isEmpty() ? "-1\n" : q.poll() + "\n");
            }
            else if (cmd[0].equals("size")) {
                bw.write(q.size() + "\n");
            }
            else if (cmd[0].equals("empty")) {
                bw.write(q.isEmpty() ? "1\n" : "0\n");
            }
            else if (cmd[0].equals("front")) {
                bw.write(q.isEmpty() ? "-1\n" : q.peek() + "\n");
            }
            else if (cmd[0].equals("back")) {
                bw.write(q.isEmpty() ? "-1\n" : lastValue + "\n");
            }
        }
        bw.flush();
    }
}
