#include <stdio.h>

int T, H, W, N;

int main()
{
    scanf("%d", &T);
    while (T--)
    {
        scanf("%d %d %d", &H, &W, &N);

        int floor = (N - 1) % H + 1;
        int number = (N - 1) / H + 1;

        printf("%d%02d\n", floor, number);
    }
    return 0;
}
