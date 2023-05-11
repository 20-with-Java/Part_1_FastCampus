#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N, M;

    scanf("%d %d", &N, &M);
    vector<int> v(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &v[i]);

    sort(v.begin(), v.end());

    int ans_diff = v[N - 1] - v[0];
    int right = 0;
    for (int left = 0; left < N; left++)
    {
        while (v[right] - v[left] < M && right < N - 1)
            right++;
        int diff = v[right] - v[left];
        if (diff >= M)
            ans_diff = min(ans_diff, diff);
    }

    printf("%d\n", ans_diff);
    return 0;
}
