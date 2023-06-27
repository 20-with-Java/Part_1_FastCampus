#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N, M, num;
    scanf("%d %d", &N, &M);

    vector<int> acc(N + 1);
    for (int i = 1; i <= N; i++)
    {
        scanf("%d", &num);
        acc[i] = acc[i - 1] + num;
    }

    int ans = 0;
    for (int i = 1; i <= N; i++)
    {
        int l = i, r = N;
        while (l <= r)
        {
            int m = (l + r) / 2;
            long long sum = acc[m] - acc[i - 1];
            
            if (sum > M)
                r = m - 1;
            else if (sum < M)
                l = m + 1;
            else
            {
                ans++;
                break;
            }
        }
    }

    printf("%d\n", ans);
    return 0;
}
