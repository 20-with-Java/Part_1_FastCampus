import java.util.Arrays;
import java.util.Comparator;

class Main
{
    static class Member{
        String name;
        int age;
        Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main (String[] args) {
        Member[] members = {
                new Member("Carol", 23),
                new Member("Bob", 27),
                new Member("Erin", 31),
                new Member("Alice", 27),
                new Member("Dave", 19)
        };

        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.age != o2.age)
                    return o1.age - o2.age; // 나이에 대한 오름차순
                // 나이가 같다면 이름에 대한 사전순
                return o1.name.compareTo(o2.name);
            }
        });

        // 아래와 같이 Lambda 사용 가능
        // Arrays.sort(members, (o1, o2) -> (o1.age == o2.age? o1.name.compareTo(o2.name) : o1.age - o2.age));

        for (Member member : members)
            System.out.println(member.age + " " + member.name);
    }
}