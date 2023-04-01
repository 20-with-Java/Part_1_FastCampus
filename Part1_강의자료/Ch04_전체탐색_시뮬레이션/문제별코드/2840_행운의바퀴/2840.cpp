#include <stdio.h>
#include <string.h>

int N, K, S;
char C;
char ans[25];
int check[26];

int main()
{
    scanf("%d %d", &N, &K);

    int cur_idx = 0;
    memset(ans, '?', sizeof(ans));
    while (K--)
    {
        scanf("%d %c", &S, &C);
        int next_idx = ((cur_idx - S) % N + N) % N;
        if (ans[next_idx] == '?')
            ans[next_idx] = C;
        else if (ans[next_idx] != C)
        {
            printf("!\n");
            return 0;
        }
        cur_idx = next_idx;
    }

    for (int i = 0; i < N; i++)
    {
        if (ans[i] == '?')
            continue;
        if (check[ans[i] - 'A'])
        {
            printf("!\n");
            return 0;
        }
        check[ans[i] - 'A'] = 1;
    }

    for (int i = 0; i < N; i++)
        printf("%c", ans[(cur_idx + i) % N]);
    printf("\n");
    return 0;
}
