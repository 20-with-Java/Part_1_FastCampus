import java.util.*;
import java.util.stream.Collectors;

class Student {
    int number;
    int scr;
    int postedAt;
    Student(int number, int scr, int postedAt) {
        this.number = number;
        this.scr = scr;
        this.postedAt = postedAt;
    }
}

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int R = sc.nextInt();
        List<Student> post = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            int votedNumber = sc.nextInt();
            boolean alreadyPosted = false;
            for (int j = 0; j < post.size(); j++)
                if (post.get(j).number == votedNumber) {
                    post.get(j).scr++;
                    alreadyPosted = true;
                    break;
                }

            if (!alreadyPosted) {
                if (post.size() < N) post.add(0, new Student(votedNumber, 1, i));
                else {
                    Collections.sort(post, (o1, o2) ->
                            o1.scr == o2.scr ? o1.postedAt - o2.postedAt : o1.scr - o2.scr);
                    post.set(0, new Student(votedNumber, 1, i));
                }
            }
        }

        Collections.sort(post, (o1, o2) -> o1.number - o2.number);
        System.out.println(post.stream()
                .map(student -> String.valueOf(student.number))
                .collect(Collectors.joining(" ")));
    }
}
