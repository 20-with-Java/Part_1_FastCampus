#include <stdio.h>
#include <string.h>
#include <utility>

using namespace std;

int main()
{
    bool pass_vertical[12][12] = {}, pass_horizontal[12][12] = {};
    char command[255];
    int N;
    pair<int, int> cur = make_pair(0, 0);

    scanf("%d %s", &N, command);

    for (int i = 0; i < strlen(command); i++)
    {
        if (command[i] == 'U')
        {
            if (cur.first > 0)
            {
                pass_horizontal[cur.first][cur.second] = true;
                pass_horizontal[--cur.first][cur.second] = true;
            }
        }
        else if (command[i] == 'D')
        {
            if (cur.first < N - 1)
            {
                pass_horizontal[cur.first][cur.second] = true;
                pass_horizontal[++cur.first][cur.second] = true;
            }
        }
        else if (command[i] == 'L')
        {
            if (cur.second > 0)
            {
                pass_vertical[cur.first][cur.second] = true;
                pass_vertical[cur.first][--cur.second] = true;
            }
        }
        else if (command[i] == 'R')
        {
            if (cur.second < N - 1)
            {
                pass_vertical[cur.first][cur.second] = true;
                pass_vertical[cur.first][++cur.second] = true;
            }
        }
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (!pass_vertical[i][j] && !pass_horizontal[i][j])
                printf(".");
            else if (!pass_vertical[i][j] && pass_horizontal[i][j])
                printf("|");
            else if (pass_vertical[i][j] && !pass_horizontal[i][j])
                printf("-");
            else
                printf("+");
        }
        printf("\n");
    }
    return 0;
}
