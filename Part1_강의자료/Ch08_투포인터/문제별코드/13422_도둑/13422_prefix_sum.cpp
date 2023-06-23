#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int T;
    scanf("%d", &T);
    while (T--)
    {
        int N, M, K;
        scanf("%d %d %d", &N, &M, &K);

        vector<int> vec(N), acc(N + M);
        for (int i = 0; i < N; i++)
            scanf("%d", &vec[i]);

        acc[0] = vec[0];
        for (int i = 1; i < N + M; i++)
            acc[i] = acc[i - 1] + vec[i % N];
        
        int ans = 0;
        for (int i = M; i < N + M; i++)
            if (acc[i] - acc[i - M] < K)
                ans++;

        if (N == M && ans > 0)
            ans = 1;
        printf("%d\n", ans);
    }
    return 0;
}
