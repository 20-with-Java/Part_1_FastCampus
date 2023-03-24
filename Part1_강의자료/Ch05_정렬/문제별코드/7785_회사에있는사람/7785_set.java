import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Set<String> entered = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            String status = sc.next();
            if (status.equals("enter"))
                entered.add(name);
            else entered.remove(name);
        }

        String[] orderedAnswer = entered.toArray(new String[entered.size()]);
        for (int i = orderedAnswer.length - 1; i >= 0; i--)
            System.out.println(orderedAnswer[i]);
    }
}
