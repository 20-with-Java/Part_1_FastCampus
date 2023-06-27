#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N, K, B;
    scanf("%d %d %d", &N, &K, &B);

    int b;
    vector<bool> is_broken(N + 1);
    while (B--)
    {
        scanf("%d", &b);
        is_broken[b] = true;
    }

    int broken_cnt = 0;
    for (int i = 1; i <= K; i++)
        broken_cnt += is_broken[i];

    int ans = broken_cnt;
    for (int i = 2; i <= N - K + 1; i++)
    {
        broken_cnt += is_broken[i + K - 1] - is_broken[i - 1];
        ans = min(ans, broken_cnt);
    }
    printf("%d\n", ans);
    return 0;
}
