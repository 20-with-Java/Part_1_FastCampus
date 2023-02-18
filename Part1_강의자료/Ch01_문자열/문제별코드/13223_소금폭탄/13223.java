import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] current = sc.next().split(":");
        String[] target = sc.next().split(":");

        int current_h = Integer.parseInt(current[0]);
        int current_m = Integer.parseInt(current[1]);
        int current_s = Integer.parseInt(current[2]);

        int target_h = Integer.parseInt(target[0]);
        int target_m = Integer.parseInt(target[1]);
        int target_s = Integer.parseInt(target[2]);

        int current_sec = current_h * 3600 + current_m * 60 + current_s;
        int target_sec = target_h * 3600 + target_m * 60 + target_s;

        int need_sec = target_sec - current_sec;
        if (need_sec <= 0) need_sec += 24 * 3600;

        int need_h = need_sec / 3600;
        int need_m = (need_sec % 3600) / 60;
        int need_s = need_sec % 60;

        System.out.println(String.format("%02d:%02d:%02d", need_h, need_m, need_s));
    }
}
