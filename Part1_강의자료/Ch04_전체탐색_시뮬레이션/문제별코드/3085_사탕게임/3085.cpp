#include <algorithm>
#include <stdio.h>
#include <assert.h>

using namespace std;

int N, res = -1;
char board[55][55];

void calc_col_score(int col)
{
    if (col >= N)
        return;
        
    char color;
    int max_score, tmp;

    max_score = 1;
    tmp = 1;
    color = board[0][col];
    for (int i = 1; i < N; i++)
    {
        if (board[i][col] != color)
        {
            max_score = max(max_score, tmp);
            tmp = 1;
            color = board[i][col];
        }
        else
            ++tmp;
    }
    res = max(res, max(max_score, tmp));
}

void calc_row_score(int row)
{
    if (row >= N)
        return;

    char color;
    int max_score, tmp;

    max_score = 1;
    tmp = 1;
    color = board[row][0];
    for (int i = 1; i < N; i++)
    {
        if (board[row][i] != color)
        {
            max_score = max(max_score, tmp);
            tmp = 1;
            color = board[row][i];
        }
        else
            ++tmp;
    }
    res = max(res, max(max_score, tmp));
}

void swap_candy(int row, int col)
{
    char color = board[row][col];

    if (color != board[row + 1][col])
    {
        swap(board[row][col], board[row + 1][col]);
        calc_row_score(row);
        calc_row_score(row + 1);
        calc_col_score(col);
        swap(board[row][col], board[row + 1][col]);
    }
    if (color != board[row][col + 1])
    {
        swap(board[row][col], board[row][col + 1]);
        calc_col_score(col);
        calc_col_score(col + 1);
        calc_row_score(row);
        swap(board[row][col], board[row][col + 1]);
    }
}

int main()
{
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        scanf("%s", board[i]);
    
    for (int i = 0; i < N; i++)
    {
        calc_row_score(i);
        calc_col_score(i);
    }

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            swap_candy(i, j);

    printf("%d\n", res);
    return 0;
}
