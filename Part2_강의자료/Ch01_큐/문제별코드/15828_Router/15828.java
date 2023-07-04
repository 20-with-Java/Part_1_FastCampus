import java.util.*;
import java.util.stream.Collectors;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> router = new LinkedList<>();
        while (true) {
            int cmd = sc.nextInt();
            if (cmd > 0) {
                if (router.size() < N)
                    router.offer(cmd);
            }
            else if (cmd == 0) {
                router.poll();
            }
            else break;
        }

        if (router.isEmpty())
            System.out.println("empty");
        else System.out.println(router.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}
