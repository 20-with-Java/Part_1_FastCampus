#include <algorithm>
#include <stdio.h>

using namespace std;

int dwarf[10];

int main()
{
    int i, j, sum = 0;

    for (i = 0; i < 9; ++i)
    {
        scanf("%d", &dwarf[i]);
        sum += dwarf[i];
    }
    sort(dwarf, dwarf + 9);
    
    bool flag = false;
    for (i = 0; i < 8; ++i)
    {
        for (j = i + 1; j < 9; ++j)
        {
            if (sum - dwarf[i] - dwarf[j] == 100)
            {
                flag = true;
                break;
            }
        }
        if (flag)
            break;
    }

    for (int k = 0; k < 9; ++k)
    {
        if (k == i || k == j)
            continue;
        printf("%d\n", dwarf[k]);
    }

    return 0;
}
