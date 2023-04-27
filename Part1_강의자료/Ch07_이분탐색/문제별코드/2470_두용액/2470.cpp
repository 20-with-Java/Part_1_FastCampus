#include <algorithm>
#include <math.h>
#include <stdio.h>
#include <vector>
using namespace std;

int find_nearest_value(vector<int> &vec, int left, int right, int value)
{
    int nearest_value = vec[left];
    int nearest_diff = abs(value - nearest_value);
    int l = left + 1, r = right;

    while (l <= r)
    {
        int mid = (l + r) / 2;
        int diff = abs(value - vec[mid]);
        if (diff < nearest_diff)
        {
            nearest_value = vec[mid];
            nearest_diff = diff;
        }
        if (vec[mid] < value)
            l = mid + 1;
        else if (vec[mid] > value)
            r = mid - 1;
        else
            return value;
    }
    return nearest_value;
}
int main()
{
    int N;
    scanf("%d", &N);

    vector<int> vec(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &vec[i]);
    sort(vec.begin(), vec.end());

    int ans_abs = abs(vec[0] + vec[1]);
    int ans1 = vec[0], ans2 = vec[1];
    for (int i = 0; i < N - 1; i++)
    {
        int pair_value = find_nearest_value(vec, i + 1, N - 1, -vec[i]);
        int sum_abs = abs(vec[i] + pair_value);
        if (ans_abs > sum_abs)
        {
            ans_abs = sum_abs;
            ans1 = vec[i];
            ans2 = pair_value;
        }
    }

    printf("%d %d\n", ans1, ans2);
    return 0;
}
