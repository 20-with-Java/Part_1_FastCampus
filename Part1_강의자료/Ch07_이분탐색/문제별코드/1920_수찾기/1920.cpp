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
    int N, M;

    scanf("%d", &N);
    vector<int> vec(N);

    for (int i = 0; i < N; i++)
        scanf("%d", &vec[i]);

    sort(vec.begin(), vec.end());

    int A;
    scanf("%d", &M);
    for (int i = 0; i < M; i++)
    {
        scanf("%d", &A);
        // printf("%d\n", binary_search(vec.begin(), vec.end(), A));
        printf("%d\n", is_exist(N, vec, A));
    }

    printf("\n");
    return 0;
}
