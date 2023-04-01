#include <stdio.h>

int S[3], sum[85];

int main()
{
    for (int i = 0; i < 3; i++)
        scanf("%d", &S[i]);
    
    for (int i = 1; i <= S[0]; i++)
        for (int j = 1; j <= S[1]; j++)
            for (int k = 1; k <= S[2]; k++)
                ++sum[i + j + k];

    int idx, cnt = -1;
    for (int i = 3; i <= 80; i++)
    {  
        if (cnt < sum[i])
        {
            idx = i;
            cnt = sum[i];
        }
    }
    printf("%d\n", idx);
    return 0;
}
