#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int calc_count(vector<int> &vec, int dist)
{
    int past_x = vec[0];
    int cnt = 1;
    for (int i = 1; i < vec.size(); i++)
    {
        if (vec[i] - past_x >= dist)
        {
            past_x = vec[i];
            cnt++;
        }
    }
    return cnt;
}

int main()
{
    int N, C;
    scanf("%d %d", &N, &C);
    vector<int> vec(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &vec[i]);
    sort(vec.begin(), vec.end());

    int l = 0, r = (vec[N - 1] - vec[0]) / (C - 1);
    while (l <= r)
    {
        int mid = (l + r) / 2;
        if (calc_count(vec, mid) >= C)
            l = mid + 1;
        else
            r = mid - 1;
    }
    printf("%d\n", r);
    return 0;
}
