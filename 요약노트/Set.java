import java.util.*;

class Main
{
    public static void main (String[] args) {
        Set<String> set = new HashSet<>();
        // 정렬된 원소를 얻고 싶다면 treeSet 구현체를 이용해야 합니다.
        // Set<String> set = new TreeSet<>();
        
        set.add("Carol");
        set.add("Alice");
        set.add("Dave");
        set.remove("Carol");
        set.add("Erin");
        set.add("Erin");    // 이미 존재한다면 추가되지 않습니다.

        System.out.println(set.size());             // 3
        System.out.println(set.contains("Alice"));  // true
        System.out.println(set.contains("Bob"));    // false

        set.remove("Bob");   // 없는 원소이므로 삭제가 수행되지 않습니다.
        set.remove("Carol");
        System.out.println(set.contains("Carol"));  // false;

        String[] unorderedKeys = set.toArray(new String[set.size()]);
        // hashSet이라면 set의 원소들이 정렬된 형태로 반환됩니다.
        for (String key : unorderedKeys)
            System.out.println(key);
    }
}
