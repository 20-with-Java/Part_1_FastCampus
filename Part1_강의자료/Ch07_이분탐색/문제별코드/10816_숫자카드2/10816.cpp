#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int find_lower_bound_idx(vector<int> &vec, int x)
{
    int idx = vec.size();
    int l = 0, r = vec.size() - 1;

    while (l <= r)
    {
        int m = (l + r) / 2;
        if (vec[m] < x)
            l = m + 1;
        else
        {
            r = m - 1;
            idx = m;
        }
    }
    return idx;
}

int find_upper_bound_idx(vector<int> &vec, int x)
{
    int idx = vec.size();
    int l = 0, r = vec.size() - 1;

    while (l <= r)
    {
        int m = (l + r) / 2;
        if (vec[m] <= x)
            l = m + 1;
        else
        {
            r = m - 1;
            idx = m;
        }
    }
    return idx;
}

int main()
{
    int N, M;

    scanf("%d", &N);
    vector<int> vec(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &vec[i]);

    sort(vec.begin(), vec.end());

    scanf("%d", &M);
    int x;
    while (M--)
    {
        scanf("%d", &x);
        printf("%d ", find_upper_bound_idx(vec, x) - find_lower_bound_idx(vec, x));

        // use stl
        // printf("%d ", upper_bound(vec.begin(), vec.end(), x) - lower_bound(vec.begin(), vec.end(), x));
    }
    printf("\n");
    return 0;
}
