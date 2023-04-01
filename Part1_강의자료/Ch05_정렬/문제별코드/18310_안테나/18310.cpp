#include <algorithm>
#include <stdio.h>
#include <vector>

using namespace std;

int N;
vector<long long> house;

int main()
{
    long long h;

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%lld", &h);
        house.push_back(h);
    }
    sort(house.begin(), house.end());
    printf("%lld\n", house[(N - 1) / 2]);

    return 0;
}
