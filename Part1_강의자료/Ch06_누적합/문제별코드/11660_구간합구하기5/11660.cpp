#include <stdio.h>
#include <vector>
using namespace std;

int main() {
    int N, M;
    vector<vector<int>> acc;

    scanf("%d %d", &N, &M);
    acc.resize(N + 1);
    for (int i = 0; i <= N; i++)
        acc[i].resize(N + 1);

    int num;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++) 
        {
            scanf("%d", &num);
            acc[i][j] = acc[i][j - 1] + acc[i - 1][j] - acc[i - 1][j - 1] + num;
        }
    }

    int x1, x2, y1, y2;
    int sum;
    while (M--)
    {
        scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
        sum = acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1];
        printf("%d\n", sum);
    }
    return 0;
}
