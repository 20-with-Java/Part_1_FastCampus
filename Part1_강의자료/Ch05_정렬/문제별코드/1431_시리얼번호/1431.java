import java.util.Arrays;
import java.util.Scanner;

class Serial {
    public Serial(String serial) {
        this.serial = serial;
        for (int i = 0; i < serial.length(); i++)
            if ('0' <= serial.charAt(i) && serial.charAt(i) <= '9')
                sum += serial.charAt(i) - '0';
    }
    String serial;
    int sum;
}

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Serial[] serials = new Serial[N];
        for (int i = 0; i < N; i++)
            serials[i] = new Serial(sc.next());

        Arrays.sort(serials, (o1, o2) -> {
            if (o1.serial.length() != o2.serial.length())
                return o1.serial.length() - o2.serial.length();
            if (o1.sum != o2.sum)
                return o1.sum - o2.sum;
            return o1.serial.compareTo(o2.serial);
        });

        for (Serial s : serials)
            System.out.println(s.serial);
    }
}
