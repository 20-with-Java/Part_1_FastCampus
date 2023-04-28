#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int calc_count(vector<long long> &lans, int len)
{
    long long cnt = 0;

    for (auto & it : lans)
        cnt += it / len;
    return cnt;
}

int main()
{
    int K, N;
    scanf("%d %d", &K, &N);

    vector<long long> lans(N);
    long long l = 1, r = -1;
    for (int i = 0; i < K; i++)
    {
        scanf("%lld", &lans[i]);
        r = max(r, lans[i]);
    }

    long long res = -1;
    while (l <= r)
    {
        long long mid = (l + r) / 2;
        if (calc_count(lans, mid) >= N)
        {
            l = mid + 1;
            res = mid;
        }
        else
            r = mid - 1;
    }
    printf("%lld\n", res);
    return 0;
}
