import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        String origin = sc.next();
        List<Character> list = new LinkedList<>();
        for (char alp : origin.toCharArray())
            list.add(alp);

        int M = sc.nextInt();
        ListIterator<Character> it = list.listIterator(origin.length());
        while (M-- > 0) {
            char cmd = sc.next().charAt(0);
            if (cmd == 'L') {
                // 커서를 왼쪽으로 옮김, 맨 앞이면 무시
                if (it.hasPrevious())
                    it.previous();
            }
            else if (cmd == 'D') {
                // 커서를 오른쪽으로 옮김, 맨 뒤면 무시
                if (it.hasNext())
                    it.next();
            }
            else if (cmd == 'B') {
                // 커서 왼쪽의 문자를 삭제, 맨 앞이면 무시
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            }
            else if (cmd == 'P') {
                // 입력받은 문자를 커서 왼쪽에 추가
                it.add(sc.next().charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char alp : list)
            sb.append(alp);
        System.out.println(sb.toString());
    }
}
