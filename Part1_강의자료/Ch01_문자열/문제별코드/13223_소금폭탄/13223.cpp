#include <stdio.h>

int main()
{
    int current_h, current_m, current_s;
    int target_h, target_m, target_s;

    scanf("%d:%d:%d", &current_h, &current_m, &current_s);
    scanf("%d:%d:%d", &target_h, &target_m, &target_s);

    int current_sec = current_h * 3600 + current_m * 60 + current_s;
    int target_sec = target_h * 3600 + target_m * 60 + target_s;

    int need_sec = target_sec - current_sec;
    if (need_sec <= 0) need_sec += 24 * 3600;

    int need_h = need_sec / 3600;
    int need_m = (need_sec % 3600) / 60;
    int need_s = need_sec % 60;

    printf("%02d:%02d:%02d\n", need_h, need_m, need_s);
    return 0;
}
