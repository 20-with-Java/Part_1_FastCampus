#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

struct Bucket {
    int g;
    int x;
    bool operator<(const Bucket &o)const {
        return x < o.x;
    }
};

int main()
{
    int N, K;

    scanf("%d %d", &N, &K);
    vector<Bucket> buckets(N);
    for (int i = 0; i < N; i++)
        scanf("%d %d", &buckets[i].g, &buckets[i].x);

    sort(buckets.begin(), buckets.end());

    int next = 0;
    int max_sum = 0;
    int cur_sum = 0;
    for (int i = 0; i < N; i++)
    {
        while (next < N && buckets[next].x - buckets[i].x <= 2 * K)
            cur_sum += buckets[next++].g;
        max_sum = max(max_sum, cur_sum);
        cur_sum -= buckets[i].g;
    }

    printf("%d\n", max_sum);
    return 0;
}
