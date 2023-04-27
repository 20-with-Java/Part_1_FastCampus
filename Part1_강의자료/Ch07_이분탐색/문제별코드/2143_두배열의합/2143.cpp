#include <algorithm>
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

    vector<int> part_sum;
    for (int i = 0; i < N; i++)
    {
        int sum = 0;
        for (int j = i; j < N; j++)
        {
            sum += vec1[j];
            part_sum.push_back(sum);
        }
    }
    sort(part_sum.begin(), part_sum.end());

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
            int to_find = T - sum;
            res += (long long)(upper_bound(part_sum.begin(), part_sum.end(), to_find) - lower_bound(part_sum.begin(), part_sum.end(), to_find));
        }
    }

    printf("%lld\n", res);
    return 0;
}
