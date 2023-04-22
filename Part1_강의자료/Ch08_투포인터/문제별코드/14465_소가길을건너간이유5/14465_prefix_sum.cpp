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

    vector<int> acc_broken(N + 1);
    for (int i = 1; i <= N; i++)
        acc_broken[i] = acc_broken[i - 1] + is_broken[i];
    
    int ans = K, cur;
    for (int i = 1; i <= N - K + 1; i++)
    {
        cur = acc_broken[i + K - 1] - acc_broken[i - 1];
        ans = min(ans, cur);
    }
    printf("%d\n", ans);
    return 0;
}
