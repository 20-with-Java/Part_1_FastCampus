import java.util.Arrays;

class Main
{
    static class Member implements Comparable<Member>{
        String name;
        int age;

        Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Member o) {
            if (age != o.age)
                return age - o.age; // 나이에 대한 오름차순
            // 나이가 같다면 이름에 대한 사전순
            return name.compareTo(o.name);
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

        Arrays.sort(members);

        for (Member member : members)
            System.out.println(member.age + " " + member.name);
    }
}