#include <stdio.h>

int main()
{
    int N, M, arr[10005];
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++)
        scanf("%d", &arr[i]);

    int next_index = 0, current_sum = 0, ans = 0;
    for (int i = 0; i < N; i++)
    {
        while (current_sum < M && next_index < N)
            current_sum += arr[next_index++];
        if (current_sum == M)
            ans++;
        current_sum -= arr[i];
    }

    printf("%d\n", ans);
    return 0;
}
