import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push")) {
                stack.offerLast(Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("pop")) {
                bw.write(stack.isEmpty() ? "-1\n" : stack.pollLast() + "\n");
            }
            else if (cmd[0].equals("size")) {
                bw.write(stack.size() + "\n");
            }
            else if (cmd[0].equals("empty")) {
                bw.write(stack.isEmpty() ? "1\n" : "0\n");
            }
            else if (cmd[0].equals("top")) {
                bw.write(stack.isEmpty() ? "-1\n" : stack.peekLast() + "\n");
            }
        }
        bw.flush();
    }
}
