#include <algorithm>
#include <set>
#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N;

    scanf("%d", &N);
    vector<int> vec(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &vec[i]);

    set<int> sums;
    for (int i = 0; i < N; i++)
        for (int j = i; j < N; j++)
            sums.insert(vec[i] + vec[j]);

    sort(vec.begin(), vec.end());
    for (int i = N - 1; i > 0; i--)
    {
        for (int j = i - 1; j >= 0; j--)
        {
            if (sums.find(vec[i] - vec[j]) != sums.end())
            {
                printf("%d\n", vec[i]);
                return 0;
            }
        }
    }

    return 0;
}
