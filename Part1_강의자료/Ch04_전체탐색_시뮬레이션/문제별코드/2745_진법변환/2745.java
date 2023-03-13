import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String numberInBase = sc.next();
        int base = sc.nextInt();
        int numberInDecimal = 0;
        for (int i = 0; i < numberInBase.length(); i++) {
            char digit = numberInBase.charAt(i);
            numberInDecimal *= base;
            if ('0' <= digit && digit <= '9') numberInDecimal += digit - '0';
            else numberInDecimal += 10 + digit - 'A';
        }
        System.out.println(numberInDecimal);
    }
}
