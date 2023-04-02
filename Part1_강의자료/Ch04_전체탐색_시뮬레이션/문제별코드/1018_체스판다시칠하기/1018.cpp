#include <stdio.h>
#include <algorithm>
using namespace std;

int N, M;
char map[51][51];

int count_diff(int row, int col, char *pattern)
{
    int cnt = 0;
    for (int i = row; i < row + 8; i++)
        for (int j = col; j < col + 8; j++)
            if (map[i][j] != pattern[(i + j) % 2])
                cnt++;
    return cnt;
}

int main()
{
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++)
        scanf("%s", map[i]);

    int ans = N * M;
    for (int i = 0; i <= N - 8; i++)
    {
        for (int j = 0; j <= M - 8; j++)
        {
            int cnt_BW = count_diff(i, j, "BW");
            int cnt_WB = count_diff(i, j, "WB");
            ans = min(ans, min(cnt_BW, cnt_WB));
        }
    }
    
    printf("%d\n", ans);
    return 0;
}
