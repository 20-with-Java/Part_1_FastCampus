#include <stdio.h>
#include <string.h>
#include <utility>

using namespace std;

char command[255];
int N, board[12][12];

int main()
{
    pair<int, int> cur = make_pair(0, 0);
    scanf("%d %s", &N, command);

    for (int i = 0; i < strlen(command); i++)
    {
        if (command[i] == 'U')
        {
            if (cur.first > 0)
            {
                board[cur.first][cur.second] |= 1;
                board[--cur.first][cur.second] |= 1;
            }
        }
        else if (command[i] == 'D')
        {
            if (cur.first < N - 1)
            {
                board[cur.first][cur.second] |= 1;
                board[++cur.first][cur.second] |= 1;
            }
        }
        else if (command[i] == 'L')
        {
            if (cur.second > 0)
            {
                board[cur.first][cur.second] |= 2;
                board[cur.first][--cur.second] |= 2;
            }
        }
        else if (command[i] == 'R')
        {
            if (cur.second < N - 1)
            {
                board[cur.first][cur.second] |= 2;
                board[cur.first][++cur.second] |= 2;
            }
        }
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (board[i][j] == 0)
                printf(".");
            else if (board[i][j] == 1)
                printf("|");
            else if (board[i][j] == 2)
                printf("-");
            else if (board[i][j] == 3)
                printf("+");
        }
        printf("\n");
    }
    return 0;
}
