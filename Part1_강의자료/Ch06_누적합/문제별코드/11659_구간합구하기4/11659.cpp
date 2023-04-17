#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N, M;

    scanf("%d %d", &N, &M);
    vector<int> arr(N + 1);
    for (int i = 1; i <= N; i++)
        scanf("%d", &arr[i]);

    vector<int> acc(N + 1);
    for (int i = 1; i <= N; i++)
        acc[i] = acc[i - 1] + arr[i];

    while (M--)
    {
        int i, j;
        scanf("%d %d", &i, &j);
        printf("%d\n", acc[j] - acc[i - 1]);
    }
    return 0;
}
