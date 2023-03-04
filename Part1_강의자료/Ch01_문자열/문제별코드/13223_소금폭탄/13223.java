import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] current = sc.next().split(":");
        String[] target = sc.next().split(":");

        int currentHour = Integer.parseInt(current[0]);
        int currentMinute = Integer.parseInt(current[1]);
        int currentSecond = Integer.parseInt(current[2]);

        int targetHour = Integer.parseInt(target[0]);
        int targetMinute = Integer.parseInt(target[1]);
        int targetSecond = Integer.parseInt(target[2]);

        int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;
        int targetSecondAmount = targetHour * 3600 + targetMinute * 60 + targetSecond;

        int NeedSecondAmount = targetSecondAmount - currentSecondAmount;
        if (NeedSecondAmount <= 0) NeedSecondAmount += 24 * 3600;

        int needHour = NeedSecondAmount / 3600;
        int needMinute = (NeedSecondAmount % 3600) / 60;
        int needSecond = NeedSecondAmount % 60;

        System.out.println(String.format("%02d:%02d:%02d", needHour, needMinute, needSecond));
    }
}
