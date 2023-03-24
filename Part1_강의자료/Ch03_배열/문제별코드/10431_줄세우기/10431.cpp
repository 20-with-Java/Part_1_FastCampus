#include <stdio.h>

int P, T;
int h[20];

int main()
{
    scanf("%d", &P);
    while (P--)
    {
        scanf("%d", &T);
        for(int i = 0; i < 20; i++)
            scanf("%d", h + i);

        int cnt = 0;
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if (h[j] > h[i])
                {
                    int myH = h[i];
                    for(int k = i; k > j; k--)
                    {
                        h[k] = h[k - 1];
                        cnt++;
                    }
                    h[j] = myH;
                    break;
                }
            }
        }

        printf("%d %d\n", T, cnt);
    }
    return 0;
}
