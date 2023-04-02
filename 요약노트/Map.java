import java.util.*;

class Main
{
    public static void main (String[] args) {
        Map<String, Integer> map = new HashMap<>();
        // key가 정렬된 형태를 원한다면 treeMap 구현체를 이용해야 합니다.
        // Map<String, Integer> map = new TreeMap<>();

        map.put("Carol", 23);
        map.put("Alice", 27);
        map.put("Dave", 19);
        map.remove("Carol");
        map.put("Erin", 31);
        map.put("Erin", 21);    // 이미 존재한다면 덮어씌웁니다.
        System.out.println("Erin's age: " + map.get("Erin"));   // 21

        System.out.println("# of members: "  + map.size());             // 3
        System.out.println("Alice exist: " + map.containsKey("Alice")); // true
        System.out.println("Bob exist: " + map.containsKey("Bob"));     // false

        map.remove("Bob");      // 없는 원소이므로 삭제가 수행되지 않습니다.
        map.remove("Carol");
        System.out.println("Carol exist: " + map.containsKey("Carol")); // false;

        // hashMap이라면 key의 사전순으로 출력됩니다.
        for (Map.Entry<String, Integer> member: map.entrySet())
            System.out.println("name: " + member.getKey() + ", age: " + member.getValue());

        // forEach 메서드에 Lambda 사용이 가능합니다.
        // map.forEach((name, age) -> System.out.println("name: " + name + ", age: " + age));
    }
}
