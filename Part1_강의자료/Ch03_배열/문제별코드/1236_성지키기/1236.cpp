#include <algorithm>
#include <stdio.h>

using namespace std;

char castle[55][55];
int row_exist[55], col_exist[55];
int N, M;

int main()
{
    scanf(" %d %d", &N, &M);
    for (int i = 0; i < N; ++i)
        scanf(" %s", castle[i]);

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            if (castle[i][j] == 'X')
            {
                row_exist[i] = 1;
                col_exist[j] = 1;
            }
        }
    }

    int row = N;
    for (int i = 0; i < N; ++i)
        row -= row_exist[i];
    
    int col = M;
    for (int i = 0; i < M; ++i)
        col -= col_exist[i];
    
    printf("%d\n", max(row, col));
    return 0;
}
