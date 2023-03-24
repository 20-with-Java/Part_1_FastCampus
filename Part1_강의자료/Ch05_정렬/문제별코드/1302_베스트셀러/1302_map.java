import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<String, Integer> titles = new HashMap<String, Integer>();
        for (int i = 0; i < N; i++) {
            String title = sc.next();
            titles.put(title, titles.getOrDefault(title, 0) + 1);
        }

        String maxTitle = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> title : titles.entrySet()) {
            if (title.getValue() > maxCount ||
                    (title.getValue() == maxCount && title.getKey().compareTo(maxTitle) < 0)) {
                maxTitle = title.getKey();
                maxCount = title.getValue();
            }
        }
        System.out.println(maxTitle);
    }
}
