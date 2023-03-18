#include <stdio.h>

int W, H, P, Q, T;

int main()
{
    scanf("%d %d", &W, &H);
    scanf("%d %d", &P, &Q);
    scanf("%d", &T);

    int p = (P + T) % (2 * W);
    int q = (Q + T) % (2 * H);
    if (p > W)
        p = 2 * W - p;
    if (q > H)
        q = 2 * H - q;

    printf("%d %d\n", p, q);
    return 0;
}
