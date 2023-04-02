#include <stdio.h>

int N;

int generate(int seed)
{
    int num = seed;
    while (seed > 0)
    {
        num += seed % 10;
        seed /= 10;
    }
    return num;
}

int main()
{
    scanf("%d", &N);

    int ans = 0;
    for (int i = 0; i <= N; i++)
    {
        if (generate(i) == N)
        {
            ans = i;
            break;
        }
    }

    printf("%d\n", ans);
    return 0;
}
