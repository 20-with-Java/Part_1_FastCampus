#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int main() 
{
    long long N, M, max_height = -1;

    scanf("%lld %lld", &N, &M);
    vector<long long> trees(N);
    
    max_height = -1;
    for (int i = 0; i < N; i++)
    {
        scanf("%lld", &trees[i]);
        max_height = max(trees[i], max_height);
    }

    long long min_height = 0;
    while (min_height <= max_height)
    {
        long long mid = (max_height + min_height) / 2;
        long long sum = 0;

        for (auto & it : trees)
            if (it > mid)
                sum += it - mid;

        if (sum < M)
            max_height = mid - 1;
        else
            min_height = mid + 1;
    }

    printf("%lld\n", max_height);
    return 0;
}
