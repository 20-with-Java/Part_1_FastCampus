import java.util.Scanner;

class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();
        int start_index = 0;
        int count = 0;
        while (true) {
            int find_index = doc.indexOf(word, start_index);
            if (find_index < 0)
                break;
            start_index = find_index + word.length();
            count++;
        }
        System.out.println(count);
    }
}
