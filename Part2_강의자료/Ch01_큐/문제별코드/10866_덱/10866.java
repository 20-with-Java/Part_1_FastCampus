import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push_front")) {
                q.offerFirst(Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("push_back")) {
                q.offerLast(Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("pop_front")) {
                bw.write(q.isEmpty() ? "-1\n" : q.pollFirst() + "\n");
            }
            else if (cmd[0].equals("pop_back")) {
                bw.write(q.isEmpty() ? "-1\n" : q.pollLast() + "\n");
            }
            else if (cmd[0].equals("size")) {
                bw.write(q.size() + "\n");
            }
            else if (cmd[0].equals("empty")) {
                bw.write(q.isEmpty() ? "1\n" : "0\n");
            }
            else if (cmd[0].equals("front")) {
                bw.write(q.isEmpty() ? "-1\n" : q.peekFirst() + "\n");
            }
            else if (cmd[0].equals("back")) {
                bw.write(q.isEmpty() ? "-1\n" : q.peekLast() + "\n");
            }
        }
        bw.flush();
    }
}
