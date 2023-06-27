#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N, S;
    long long num;
    scanf("%d %d", &N, &S);

    vector<long long> acc(N + 1);
    for (int i = 1; i <= N; i++)
    {
        scanf("%lld", &num);
        acc[i] = acc[i - 1] + num;
    }

    int ans = N + 1;
    for (int i = 1; i <= N; i++)
    {
        int l = i, r = N;
        while (l <= r)
        {
            int m = (l + r) / 2;
            long long sum = acc[m] - acc[i - 1];

            if (sum >= S)
            {
                ans = min(ans, m - i + 1);
                r = m - 1;
            }
            else
                l = m + 1;
        }
    }

    printf("%d\n", ans == N + 1 ? 0 : ans);
    return 0;
}
