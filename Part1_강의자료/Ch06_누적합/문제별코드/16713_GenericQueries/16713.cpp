#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N, Q;

    scanf("%d %d", &N, &Q);
    vector<int> arr(N + 1);
    for (int i = 1; i <= N; i++)
        scanf("%d", &arr[i]);

    vector<int> acc(N + 1);
    for (int i = 1; i <= N; i++)
        acc[i] = acc[i - 1] ^ arr[i];

    int ans = 0;
    while (Q--)
    {
        int s, e;
        scanf("%d %d", &s, &e);
        ans ^= acc[e] ^ acc[s - 1];
    }
    printf("%d\n", ans);
    return 0;
}
