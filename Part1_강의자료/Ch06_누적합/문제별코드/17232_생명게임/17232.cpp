#include <algorithm>
#include <stdio.h>
using namespace std;

void set_prefix_sum(int N, int M, int acc[105][105], char board[105][105])
{
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= M; j++)
        {
            acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1];
            if (board[i][j] == '*')
                acc[i][j]++;
        }
    }
}

int get_range_sum(int N, int M, int K, int row, int col, int alive, int acc[105][105])
{
    int left = max(0, col - K - 1);
    int right = min(M, col + K);
    int up = max(0, row - K - 1);
    int down = min(N, row + K);

    return acc[down][right] - acc[down][left] 
        - acc[up][right] + acc[up][left] - alive;
}

int main()
{
    char board[105][105];
    int N, M, T, K, A, B, acc[105][105];

    scanf("%d %d %d %d %d %d", &N, &M, &T, &K, &A, &B);
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= M; j++)
            scanf(" %c", &board[i][j]);
    
    while (T--)
    {
        set_prefix_sum(N, M, acc, board);
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= M; j++)
            {
                int near_alive;
                if (board[i][j] == '*')
                {
                    near_alive = get_range_sum(N, M, K, i, j, 1, acc);
                    if (near_alive < A || B < near_alive)
                        board[i][j] = '.';
                }
                else
                {
                    near_alive = get_range_sum(N, M, K, i, j, 0, acc);
                    if (A < near_alive && near_alive <= B)
                        board[i][j] = '*';
                }
            }
        }
    }
    
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= M; j++)
            printf("%c", board[i][j]);
        printf("\n");
    }
    return 0;
}
