#include <algorithm>
#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N, S;
    scanf("%d %d", &N, &S);

    vector<int> vec(N);
    for (int i = 0; i < N; i++)
        scanf("%d", &vec[i]);

    int next_index = 0, current_sum = 0, ans = N + 1;
    for (int i = 0; i < N; i++)
    {
        while (current_sum < S && next_index < N)
            current_sum += vec[next_index++];
        if (current_sum >= S)
            ans = min(ans, next_index - i);
        current_sum -= vec[i];
    }

    printf("%d\n", ans == N + 1 ? 0 : ans);
    return 0;
}
