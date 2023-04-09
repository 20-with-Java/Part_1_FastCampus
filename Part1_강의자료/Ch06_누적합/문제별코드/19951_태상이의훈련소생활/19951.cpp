#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
    int N, M;
    scanf("%d %d", &N, &M);

    vector<int> arr(N + 1), acc(N + 1);
    for (int i = 1; i <= N; i++)
        scanf("%d", &arr[i]);
    
    int a, b, k;
    while (M--)
    {
        scanf("%d %d %d", &a, &b, &k);
        acc[a] += k;
        acc[b + 1] -= k;
    }

    int sum = 0;
    for (int i = 1; i <= N; i++)
    {
        sum += acc[i];
        printf("%d ", arr[i] + sum);
    }
    printf("\n");
    return 0;
}
