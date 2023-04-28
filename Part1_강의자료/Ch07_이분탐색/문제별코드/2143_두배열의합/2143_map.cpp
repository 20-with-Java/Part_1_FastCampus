#include <map>
#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N, T, num;
    scanf("%d %d", &T, &N);

    vector<int> vec1(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &vec1[i]);

    map<int, int> mp;
    for (int i = 0; i < N; i++)
    {
        int sum = 0;
        for (int j = i; j < N; j++)
        {
            sum += vec1[j];
            mp[sum] += 1;
        }
    }

    int M;
    scanf("%d", &M);

    vector<int> vec2(M);
    for (int i = 0; i < M; i++)
        scanf("%d", &vec2[i]);

    long long res = 0;
    for (int i = 0; i < M; i++)
    {
        int sum = 0;
        for (int j = i; j < M; j++)
        {
            sum += vec2[j];
            auto found = mp.find(T - sum);
            if (found != mp.end())
                res += (long long)found->second;
        }
    }

    printf("%lld\n", res);
    return 0;
}
