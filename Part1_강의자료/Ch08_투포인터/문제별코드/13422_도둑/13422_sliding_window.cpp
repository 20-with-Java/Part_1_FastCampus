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

        vector<int> vec(N);
        for (int i = 0; i < N; i++)
            scanf("%d", &vec[i]);

        int current_sum = 0;
        for (int i = 0; i < M; i++)
            current_sum += vec[i];
        
        int ans = (current_sum < K ? 1 : 0);
        if (N != M)
        {
            for (int i = 1; i < N; i++)
            {
                current_sum -= vec[i - 1];
                current_sum += vec[(i + M - 1) % N];
                if (current_sum < K)
                    ans++;
            }
        }
        printf("%d\n", ans);
    }
    return 0;
}
