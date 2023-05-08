#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int is_exist(int N, vector<int> &vec, int A)
{
    int left = 0, right = N - 1, mid;

    while (left <= right)
    {
        mid = (left + right) / 2;
        if (vec[mid] < A)
            left = mid + 1;
        else if (vec[mid] > A)
            right = mid - 1;
        else
            return 1;
    }
    return 0;
}

int main()
{
    int N;

    scanf("%d", &N);
    vector<int> vec(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &vec[i]);

    vector<int> sums(N * (N + 1) / 2);
    int sum_index = 0;
    for (int i = 0; i < N; i++)
        for (int j = i; j < N; j++)
            sums[sum_index++] = vec[i] + vec[j];

    sort(vec.begin(), vec.end());
    sort(sums.begin(), sums.end());
    for (int i = N - 1; i > 0; i--)
    {
        for (int j = i - 1; j >= 0; j--)
        {
            if (is_exist(sum_index, sums, vec[i] - vec[j]))
            {
                printf("%d\n", vec[i]);
                return 0;
            }
        }
    }

    return 0;
}
